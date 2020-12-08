package xyz.runar.chat;

import lombok.Value;

@Value
public class SavedMessage {
	Long id;
	String author;
	String message;
	Long timestamp;
}
