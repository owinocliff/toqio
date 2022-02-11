package io.toq.cardservice.data.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CardType {

    VIRTUAL("000"),
    PHYSICAL("001");

    private String cardType;

    CardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }

    @JsonCreator
    public static CardType valueOfType(String label) {

        for (CardType cardType : CardType.values()) {
            if (cardType.name().equalsIgnoreCase(label)) return cardType;
        }
        return null;
    }
}
