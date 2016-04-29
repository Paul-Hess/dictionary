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

	// tested method is not explicitly run in test because it runs by default on create of Entry instance.
	@Test 
	public void DictionaryTest_addsEntryToAllWordsCollection_2() {
		Entry testEntry = new Entry("this");
		assertEquals(Dictionary.getAll().size(), 1);
	}

	@Test 
	public void DictionarySort_hasCollectionOfSortedEntriesAlphabetically_entries() {
		Entry testEntryOne = new Entry("zoo");
		Entry testEntryTwo = new Entry("bravo");
		Entry testEntryThree = new Entry("alpha");
		Entry testEntryFour = new Entry("azure");
		assertEquals(Dictionary.getAll().get(0), testEntryThree);
		assertEquals(Dictionary.getAll().get(3), testEntryOne);
	}
	
}
