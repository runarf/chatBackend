package xyz.runar.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class NewMessageController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public SavedMessage greeting(NewMessage newMessage) {
		SavedMessage savedMessage = new SavedMessage(
			newMessage.getAuthor(),
			newMessage.getMessage(),
			1L,
			Instant.now().toEpochMilli()
		);
		return savedMessage;
	}

}
