package xyz.runar.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NewMessageController {

    @Autowired
    SavedMessagesRepository savedMessagesRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public SavedMessage greeting(NewMessage newMessage) {
        var savedMessage = savedMessagesRepository.saveNewMessage(newMessage);
        return savedMessage;
    }

}
