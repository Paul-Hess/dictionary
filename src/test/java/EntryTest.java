import org.junit.*;
import static org.junit.Assert.*;



public class EntryTest {
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
}
