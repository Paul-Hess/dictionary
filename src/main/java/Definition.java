

public class Definition {
	
	private String mMainBody;
	private int mId;
	private String mExample;
	private Integer mVoteTally;

	public Definition(String main, String example) {
		mMainBody = main;
		mExample = example;
		mVoteTally = 1;
	}

	public String getBody() {
		return mMainBody;
	}

	public String getExample() {
		return mExample;
	}


	public Integer getVoteTally() {
		return mVoteTally;
	}

	public void upVote() {
		mVoteTally+=1;
	}

	public void setId(int id) {
		mId = id;
	}

	public int getId() {
		return mId;
	}

	public static Definition findById( Entry currentEntry,int id) {
		return currentEntry.getDefinitions().get(id - 1);
	}

}