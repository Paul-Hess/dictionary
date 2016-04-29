import org.junit.*;
import static org.junit.Assert.*;


//   @After
//   public void tearDown() {
//     Task.clear();
//   }
public class WordTest {
	@Test 
	public void WordTest_WordInstantiatesCorrectly_true() {
		Word testWord = new Word("this");
		assertTrue(testWord instanceof Word);
	}
}