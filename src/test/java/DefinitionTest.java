import org.junit.*;
import static org.junit.Assert.*;


public class DefinitionTest {
	
	@Test 
	public void DefinitionTest_InstantiatesCorrectly_true() {
		Definition testDefinition = new Definition("a reference to the current thing", "this is the thing");
		assertTrue(testDefinition instanceof Definition);
	}

	@Test 
	public void DefinitionTest_InstantiatesWithBody_String() {
		Definition testDefinition = new Definition("a reference to the current thing", "this is the thing");
		assertEquals(testDefinition.getBody(), "a reference to the current thing");
	}

	@Test 
	public void DefinitionTest_InstantiatesWithExample_String() {
		Definition testDefinition = new Definition("a reference to the current thing", "this is the thing");
		assertEquals(testDefinition.getExample(), "this is the thing");
	}

	@Test 
	public void DefintionTest_InstantiatesWithVoteTallyAt1_1() {
		Definition testDefinition = new Definition("a reference to the current thing", "this is the thing");
		Integer one = 1;
		assertEquals(testDefinition.getVoteTally(), one);
	}

	@Test 
	public void DefinitionTest_increasesVoteTallyByOne_2() {
		Definition testDefinition = new Definition("a reference to the current thing", "this is the thing");
		testDefinition.upVote();
		Integer two = 2;
		assertEquals(testDefinition.getVoteTally(), two);
	}
}