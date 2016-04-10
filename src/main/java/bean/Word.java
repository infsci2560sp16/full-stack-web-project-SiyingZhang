package bean;

import java.util.UUID;
import java.util.Date;

public class Word {
	private UUID wordId;
	private String word;
	private String wordType;
	private String explanation;

	private Long createTime;
	private String createTimeString;
	
	public Word() {
		
	}

	public Word(String word, String type, String explanation) {
		this.wordId = UUID.randomUUID();
		this.word = word;
		this.wordType = type;
		this.explanation = explanation;

		this.createTime = System.currentTimeMillis();
		String s = new Date(this.createTime).toString();
		this.createTimeString = s.substring(4, 11) + "." + s.substring(24);
	}

	public UUID getWordID() {
		return this.wordId;
	}

	public void setWordId(UUID id) {
		this.wordId = id;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String w) {
		this.word = w;
	}

	public String getWordType() {
		return this.wordType;
	}

	public void setWordType(String t) {
		this.wordType = t;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public void setExplanation(String e) {
		this.explanation = e;
	}

	public String getCreateTime() {
		return this.createTimeString;
	}

	public void setCreateTimeString(String c) {
		this.createTimeString = c;
	}

}