import java.util.ArrayList;

public class Dictionary {
	private static ArrayList<Entry> allWords = new ArrayList<Entry>();

	public static ArrayList<Entry> getAll() {
		return allWords;
	}

	public static void addEntry(Entry entry) {
		allWords.add(entry);
	}

	public static void tearDown() {
		allWords.clear();
	}

}