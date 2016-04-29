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
			model.put("newWord", newEntry.getWord());
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

  }

}