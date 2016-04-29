import org.junit.*;
import static org.junit.Assert.*;


public class DictionaryTest {
	@Test 
	public void DictionaryTest_InstantiatesCorrectly_true() {
		Dictionary testDictionary = new Dictionary();
		assertTrue(testDictionary instanceof Dictionary);
	}

	@Test 
	public void DictionaryTest_InstantiatesWithEmptyWordCollection_ArrayList() {
		Dictionary testDictionary = new Dictionary();
		assertEquals(Dictionary.getAll().size(), 0);
	}

	@Test 
	public void DictionaryTest_addsEntryToAllWordsCollection() {
		Entry testEntry = new Entry("this");
		Dictionary.addEntry(testEntry);
		assertEquals(Dictionary.getAll().size(), 1);
	}
}
