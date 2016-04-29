import org.junit.*;
import static org.junit.Assert.*;


public class DictionaryTest {
	@Test 
	public void DictionaryTest_InstantiatesCorrectly_true() {
		Dictionary testDictionary = new Dictionary();
		assertTrue(testDictionary instanceof Dictionary);
	}
}
