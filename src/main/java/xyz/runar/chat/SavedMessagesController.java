package xyz.runar.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SavedMessagesController {

    @Autowired
    SavedMessagesRepository savedMessagesRepository;

    @CrossOrigin
    @GetMapping("/saved-messages")
    public List<SavedMessage> getSavedMessages() {
        return savedMessagesRepository.getSavedMessages();
    }
}
