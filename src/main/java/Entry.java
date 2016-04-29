import java.util.ArrayList;

public class Entry {
	private String mWordEntry;
	private ArrayList<Definition> mDefinitions;

	public Entry(String wordEntry) {
		mWordEntry = wordEntry;
		mDefinitions  = new ArrayList<Definition>();
		Dictionary.addEntry(this);
	}

	public String getWord() {
		return mWordEntry;
	}

	public ArrayList<Definition> getDefinitions() {
		return mDefinitions;
	}

	public void addDefinition(Definition definition) {
		mDefinitions.add(definition);
	}
}