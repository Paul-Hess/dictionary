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

	public ArrayList<Definition> getDefinitions() {
		return mDefinitions;
	}

	public void addDefinition(Definition definition) {
		mDefinitions.add(definition);
	}

		public void sort() {
		Collections.sort(mDefinitions, new Comparator<Definition>() {
 			 public int compare(Definition current, Definition comparative) {
      	return comparative.getVoteTally().compareTo(current.getVoteTally());
  		}
		});
	}


}