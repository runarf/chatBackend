package xyz.runar.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class NewMessageController {

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public SavedMessage greeting(NewMessage newMessage) {
		return new SavedMessage("Hello, " + HtmlUtils.htmlEscape(newMessage.getName()) + "!");
	}

}
