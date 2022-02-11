
package io.toq.cardservice.data.model;

import io.toq.cardservice.data.enums.CardType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Card")
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class Card {

	@Id
	@Indexed
	private String id;

	private CardType cardType;

	private String alias;

	private String accountId;

}
