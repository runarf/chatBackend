package xyz.runar.chat;

import org.springframework.data.repository.CrudRepository;

public interface SavedMessageDatabaseRepository extends CrudRepository<SavedMessage, Long> {
}
