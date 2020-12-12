package xyz.runar.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.Instant;

@Controller
public class NewMessageController {

    private Long idCount = 1L;

    @Autowired
    SavedMessageDatabaseRepository savedMessageDatabaseRepository;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public SavedMessage greeting(NewMessage newMessage) {

        Long id = idCount;
        idCount = idCount + 1;
        SavedMessage savedMessageBeforeSave = new SavedMessage(
            id,
            newMessage.getAuthor(),
            newMessage.getMessage(),
            Instant.now().toEpochMilli()
        );

        var savedMessageAfterSave = savedMessageDatabaseRepository.save(savedMessageBeforeSave);
        return savedMessageAfterSave;
    }

}
