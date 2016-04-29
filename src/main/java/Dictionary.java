import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Dictionary {
	private static ArrayList<Entry> allWords = new ArrayList<Entry>();
	private static ArrayList<Entry> sortedWords = new ArrayList<Entry>();

	public static ArrayList<Entry> getAll() {
		return allWords;
	}

	public static void addEntry(Entry entry) {
		allWords.add(entry);
	}

	public static void tearDown() {
		allWords.clear();
	}

	public static void sort() {
		Collections.sort(allWords, new Comparator<Entry>() {
 			 public int compare(Entry one, Entry other) {
      	return one.getWord().compareTo(other.getWord());
  		}
		});
	}




}