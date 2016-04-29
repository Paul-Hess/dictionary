import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-entry", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			String wordEntry = request.queryParams("word");
			Entry newEntry = new Entry(wordEntry);
			boolean success = true;
			model.put("newWord", newEntry);
			model.put("success", success);
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/all-words", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();

			model.put("dictionary", Dictionary.getAll());

      model.put("template", "templates/all-words.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/entries/:id", (request, response) -> {
    	Map<String, Object> model = new HashMap<String, Object>();

    	int id = Integer.parseInt(request.params(":id"));
    	String error = "that word is not in our records, go back to the home page and create it!";
      String noDefinitions = "no definitions here yet!";
    	Entry currentEntry;

    	if(Entry.findById(id) != null) {
    		currentEntry = Entry.findById(id);
        request.session().attribute("currentEntry", currentEntry);
    		model.put("currentEntry", currentEntry);
        
        if (currentEntry.getDefinitions().size() > 0) {
        model.put("definitions", currentEntry.getDefinitions());
        } else {
        model.put("definitions", noDefinitions);
        }

    	} else {
    		model.put("error", error);
    	}

      model.put("template", "templates/entry-detail.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/entries/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String body = request.queryParams("body");
      String example = request.queryParams("example");
      Definition newDefinition = new Definition(body, example);
      Entry currentEntry = request.session().attribute("currentEntry");
      currentEntry.addDefinition(newDefinition);
      model.put("currentEntry", currentEntry);
      model.put("definitions", currentEntry.getDefinitions());

      model.put("template", "templates/entry-detail.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/entries/:id/vote", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Entry currentEntry = request.session().attribute("currentEntry");
      int id = Integer.parseInt(request.queryParams("definition"));
      Definition currentDefinition = Definition.findById(currentEntry, id);
      currentDefinition.upVote();
      currentEntry.sort();
      model.put("currentEntry", currentEntry);
      model.put("definitions", currentEntry.getDefinitions());
      model.put("template", "templates/entry-detail.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}