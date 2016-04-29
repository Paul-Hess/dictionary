import org.junit.*;
import static org.junit.Assert.*;


public class DictionaryTest {

	@After 
	public void tearDown() {
		Dictionary.tearDown();
	}

	@Test 
	public void DictionaryTest_InstantiatesCorrectly_true() {
		Dictionary testDictionary = new Dictionary();
		assertTrue(testDictionary instanceof Dictionary);
	}

	@Test 
	public void DictionaryTest_InstantiatesWithEmptyWordCollection_0() {
		Dictionary testDictionary = new Dictionary();
		assertEquals(Dictionary.getAll().size(), 0);
	}

	@Test 
	public void DictionaryTest_clearsArrayList_0() {
		Entry testEntry = new Entry("this");
		Dictionary.tearDown();
		assertEquals(Dictionary.getAll().size(), 0);
	}

	@Test 
	public void DictionaryTest_addsEntryToAllWordsCollection_2() {
		Entry testEntry = new Entry("this");
		Dictionary.addEntry(testEntry);
		assertEquals(Dictionary.getAll().size(), 2);
	}

	@Test 
	public void DictionarySort_hasCollectionOfSortedEntriesAlphabetically_entryTwo() {
		Entry testEntryOne = new Entry("zoo");
		Entry testEntryTwo = new Entry("bravo");
		Entry testEntryThree = new Entry("alpha");
		Entry testEntryFour = new Entry("azure");
		assertEquals(Dictionary.getAll().get(0), testEntryThree);
		assertEquals(Dictionary.getAll().get(3), testEntryOne);
	}
	
}
