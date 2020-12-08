package xyz.runar.chat;


public class NewMessage {

	private String name;
	private String message;

	public NewMessage(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public String getMessage() { return message; }
}
