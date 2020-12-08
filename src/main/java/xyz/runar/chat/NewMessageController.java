package xyz.runar.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class NewMessageController {

    private Long idCount = 0L;

    private Long dateNow = Instant.now().toEpochMilli();
    private Long oneMinute = 600000L;

    private List<SavedMessage> savedMessages = Stream.of(
        new SavedMessage(0L, "Lana", "Hallo is anyone here?", dateNow),
        new SavedMessage(1L, "Mark", "Yes, I'm here.", dateNow + oneMinute),
        new SavedMessage(2L, "Kim", "I'm also here!", dateNow + 2 * oneMinute),
        new SavedMessage(
            3L,
            "Lana",
            "Ok I have a question regarding the project we started working on last week. Is there anything I can do to help?",
            dateNow + 3 * oneMinute
        )
    ).collect(Collectors.toList());

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public List<SavedMessage> greeting(NewMessage newMessage) {
        Long id = idCount;
        idCount = idCount + 1;
        SavedMessage savedMessage = new SavedMessage(
            id,
            newMessage.getAuthor(),
            newMessage.getMessage(),
            Instant.now().toEpochMilli()
        );
        savedMessages.add(savedMessage);
        return savedMessages;
    }

}
