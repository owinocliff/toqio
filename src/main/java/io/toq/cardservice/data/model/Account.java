
package io.toq.cardservice.data.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "Account")
@Getter
@Setter
@NoArgsConstructor
public class Account  {

	public static final String FIELD_CLIENT_ID = "clientId";

	public static final String FIELD_ID = "id";

	@Id
	@Indexed
	private String id;

	private String iban;

	private String bicSwift;

	private String clientId;

	private List<Card> cards;


}
