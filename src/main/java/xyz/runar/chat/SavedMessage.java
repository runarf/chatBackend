package xyz.runar.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SavedMessage {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	Long id;

	String author;
	String message;
	Long timestamp;
}
