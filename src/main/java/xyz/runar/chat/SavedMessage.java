package xyz.runar.chat;

import lombok.Value;

@Value
public class SavedMessage {
	String name;
	String message;
	Long id;
	Long timestamp;
}
