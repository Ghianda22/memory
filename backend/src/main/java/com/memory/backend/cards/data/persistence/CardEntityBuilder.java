package com.memory.backend.cards.data.persistence;

import com.memory.backend.Icons;

import java.util.UUID;

public class CardEntityBuilder {
    private UUID gameId;
    private Icons icon;
    private Integer orderInDeck;
    private Boolean isFaceUp;
    private Boolean isCollected;

    public CardEntityBuilder setGameId(UUID gameId) {
        this.gameId = gameId;
        return this;
    }

    public CardEntityBuilder setIcon(Icons icon) {
        this.icon = icon;
        return this;
    }

    public CardEntityBuilder setOrderInDeck(Integer orderInDeck) {
        this.orderInDeck = orderInDeck;
        return this;
    }

    public CardEntityBuilder setIsFaceUp(Boolean isFaceUp) {
        this.isFaceUp = isFaceUp;
        return this;
    }

    public CardEntityBuilder setIsCollected(Boolean isCollected) {
        this.isCollected = isCollected;
        return this;
    }

    public CardEntity createCardEntity() {
        return new CardEntity(gameId, icon, orderInDeck, isFaceUp, isCollected);
    }
}