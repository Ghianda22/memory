package com.memory.backend.cards.data.persistence;

import com.memory.backend.BaseEntity;
import com.memory.backend.Icons;
import jakarta.persistence.Entity;

import java.util.UUID;

@Entity
public class CardEntity extends BaseEntity {
    private UUID gameId;
    private Icons icon;
    private Integer orderInDeck;
    private Boolean isFaceUp;
    private Boolean isCollected;

    public CardEntity() {
    }

    CardEntity(UUID gameId, Icons icon, Integer orderInDeck, Boolean isFaceUp, Boolean isCollected) {
        this.gameId = gameId;
        this.icon = icon;
        this.orderInDeck = orderInDeck;
        this.isFaceUp = isFaceUp;
        this.isCollected = isCollected;
    }

    public UUID getGameId() {
        return gameId;
    }

    public Icons getIcon() {
        return icon;
    }

    public Integer getOrderInDeck() {
        return orderInDeck;
    }

    public Boolean getIsFaceUp() {
        return isFaceUp;
    }

    public Boolean getIsCollected() {
        return isCollected;
    }


    private void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    private void setIcon(Icons icon) {
        this.icon = icon;
    }

    private void setOrderInDeck(Integer orderInDeck) {
        this.orderInDeck = orderInDeck;
    }

    public void setIsFaceUp(Boolean faceUp) {
        isFaceUp = faceUp;
    }

    public void setIsCollected(Boolean collected) {
        isCollected = collected;
    }
}
