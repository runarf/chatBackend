package xyz.runar.chat;


import lombok.Value;

@Value
public class NewMessage {
	private String author;
	private String message;
}
