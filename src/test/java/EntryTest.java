import org.junit.*;
import static org.junit.Assert.*;



public class EntryTest {

	@After 
	public void tearDown() {
		Dictionary.tearDown();
	}

	@Test 
	public void WordTest_WordInstantiatesCorrectly_true() {
		Entry testEntry = new Entry("this");
		assertTrue(testEntry instanceof Entry);
	}

	@Test 
	public void WordTest_instantiatesWithWordEntry_this() {
		Entry testEntry = new Entry("this");
		assertEquals(testEntry.getWord(), "this");
	}

	@Test 
	public void WordTest_instantiatesWithEmptyDefintionsCollection_ArrayList() {
		Entry testEntry = new Entry("this");
		assertEquals(testEntry.getDefinitions().size(), 0);
	}

	@Test
	public void WordTest_addsDefintionsToInstancesOfEntries_Definition() {
		Entry testEntry = new Entry("this");
		Definition testDefinition = new Definition("a reference to the current thing", "this is the thing");
		testEntry.addDefinition(testDefinition);
		assertEquals(testEntry.getDefinitions().get(0), testDefinition);
	}

	@Test 
	public void DictionaryAndWordTest_addsSelfToDictionaryOnInstantiation_true() {
		Entry testEntry = new Entry("this");
		assertEquals(Dictionary.getAll().get(0), testEntry);
	}
}
