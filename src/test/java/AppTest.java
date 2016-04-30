import org.fluentlenium.adapter.FluentTest;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary");
  }

  @Test 
  public void makeNewEntry() {
    goTo("http://localhost:4567/");
    fill("#word").with("googleplex");
    submit(".entry-btn");
    assertThat(pageSource()).contains("success!");
    assertThat(pageSource()).contains("googleplex");
  }

  @Test 
  public void seeAllEntries() {
    goTo("http://localhost:4567/");
    fill("#word").with("googleplex");
    submit(".entry-btn");
    fill("#word").with("zoology");
    submit(".entry-btn");
    click("a", withText("here"));
    assertThat(pageSource()).contains("zoology");
  }

  @Test 
  public void seeIndividualEntry() {
    goTo("http://localhost:4567/");
    fill("#word").with("major");
    submit(".entry-btn");
    click("a", withText("here"));
    click("a", withText("major"));
    assertThat(pageSource()).contains("Add your definition to this word: ");
    assertThat(pageSource()).contains("major");
  }

  @Test 
  public void createDefinitionForEntry() {
    goTo("http://localhost:4567/");
    fill("#word").with("test");
    submit(".entry-btn");
    click("a", withText("test"));
    fill("#body").with("a mock implementation of an expiremental concept to see if results match expectations");
    fill("#example").with("the test results met expectations");
    submit(".def-btn");
    assertThat(pageSource()).contains("a mock implementation of an expiremental concept to see if results match expectations");
  }


  @Test 
  public void upVoteSpecificDefinitions() {
    goTo("http://localhost:4567/");
    fill("#word").with("test");
    submit(".entry-btn");
    click("a", withText("test"));
    fill("#body").with("a mock implementation of an expiremental concept to see if results match expectations");
    fill("#example").with("the test results met expectations");
    submit(".def-btn");
    submit("#vote-btn1");
    assertThat(pageSource()).contains("votes: 2");
  }

   @Test 
  public void featuredDefinition() {
    goTo("http://localhost:4567/");
    fill("#word").with("test");
    submit(".entry-btn");
    click("a", withText("test"));
    fill("#body").with("a mock implementation of an expiremental concept to see if results match expectations");
    fill("#example").with("the test results met expectations");
    submit(".def-btn");
    submit("#vote-btn1");
    assertThat(pageSource()).contains("Highest voted definition: ");
  }

} 