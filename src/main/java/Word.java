/*
 * Word structure
 */

public class Word {
	private int wordId;
	private String wordText;
	private String wordType;

	public void setWordId(int m) {
		this.wordId = m;
	}

	public void setWordText(String text) {
		this.wordText = text;
	}

	public void setWordType(String type) {
		this.wordType = type;
	}

	public int getWordId() {
		return this.wordId;
	}

	public String getWordText() {
		return this.wordText;
	}

	public String getWordType() {
		return this.wordText;
	}
}