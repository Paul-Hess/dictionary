
public class Definition {
	
	private String mMainBody;
	private String mExample;
	private int mVoteTally;

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


	public int getVoteTally() {
		return mVoteTally;
	}


}