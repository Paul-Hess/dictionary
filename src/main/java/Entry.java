import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class Entry {
	private String mWordEntry;
	private int mId;
	private ArrayList<Definition> mDefinitions;

	public Entry(String wordEntry) {
		mWordEntry = wordEntry;
		mDefinitions  = new ArrayList<Definition>();
		Dictionary.addEntry(this);
		mId = Dictionary.getAll().size();
		Dictionary.sort();
	}

	public String getWord() {
		return mWordEntry;
	}

	public int getId() {
		return mId;
	}

	public static Entry findById(int id) {
		Entry found = null;
		for (Entry entry : Dictionary.getAll()) {
			if (id == entry.getId()) {
				found = entry;
			}
		}
		return found;
	}

	public ArrayList<Definition> getDefinitions() {
		return mDefinitions;
	}

	public void addDefinition(Definition definition) {
		mDefinitions.add(definition);
		definition.setId(mDefinitions.size());
	}

	public Definition sort() {
		Definition featured = new Definition("", "");
		for(Definition def : mDefinitions) {
			for(Definition other : mDefinitions) {
				if(def.getVoteTally() > other.getVoteTally()) {
					featured = def;
				}
			}
		}
		return featured;
	}


}