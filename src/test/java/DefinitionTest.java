import org.junit.*;
import static org.junit.Assert.*;


public class DefinitionTest {
	@Test 
	public void DefinitionTest_InstantiatesCorrectly_true() {
		Definition testDefinition = new Definition("a reference to the current thing", "this is the thing");
		assertTrue(testDefinition instanceof Definition);

	}
}