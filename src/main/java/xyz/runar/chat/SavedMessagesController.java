package xyz.runar.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SavedMessagesController {

    @Autowired
    SavedMessageDatabaseRepository savedMessagesDatabaseRepository;

    @CrossOrigin
    @GetMapping("/saved-messages")
    public Iterable<SavedMessage> getSavedMessages() {
        var savedMessages = savedMessagesDatabaseRepository.findAll();

        return savedMessages;
    }
}
