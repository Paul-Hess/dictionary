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
	public void WordTest_instantiatesWithEmptyDefintionsCollection_0() {
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

	@Test 
	public void WordTest_instantiatesWithIncrementingId_1() {
		Entry testEntry = new Entry("this");
		assertEquals(1, testEntry.getId());
	}

	@Test 
	public void WordTest_findsEntryById_Entry() {
		Entry testEntryOne = new Entry("this");
		Entry testEntryTwo = new Entry("that");
		Entry testEntryThree = new Entry("other");
		assertEquals(Entry.findById(2), testEntryTwo);
	}

	@Test 
	public void DefinitionAndWordTest_sortsDefinitionsByHighestVoted_Definition() {
		Entry testEntry = new Entry("this");
		Definition testDefinitionOne = new Definition("this is that", "this is that thing");
		Definition testDefinitionTwo = new Definition("the thing is things are all things", "this is the thing that is a thing");
		Definition testDefinitionThree = new Definition("a reference to the current thing", "this is the thing");
		testEntry.addDefinition(testDefinitionOne);
		testEntry.addDefinition(testDefinitionTwo);
		testEntry.addDefinition(testDefinitionThree);
		testDefinitionThree.upVote();
		testEntry.sort();
		assertEquals(testEntry.getDefinitions().get(0), testDefinitionThree);
	}
}
