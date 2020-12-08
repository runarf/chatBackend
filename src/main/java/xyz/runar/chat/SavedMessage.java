package xyz.runar.chat;

public class SavedMessage {

	private String content;
	private String message;
	private String id;
	private String timestamp;

	public SavedMessage() {
	}

	public SavedMessage(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

}
