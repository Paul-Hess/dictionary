import org.junit.*;
import static org.junit.Assert.*;


//   @After
//   public void tearDown() {
//     Task.clear();
//   }
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
}