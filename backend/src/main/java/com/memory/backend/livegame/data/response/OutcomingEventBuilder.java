package com.memory.backend.livegame.data.response;

import com.memory.backend.cards.data.persistence.CardEntity;
import com.memory.backend.livegame.data.enums.ServerEvent;
import com.memory.backend.player.data.persistence.PlayerEntity;

import java.util.List;

public class OutcomingEventBuilder {
    private ServerEvent event;
    private String gameId;
    private List<PlayerEntity> updatedPlayers;
    private List<CardEntity> updatedCards;

    public OutcomingEventBuilder setEvent(ServerEvent event) {
        this.event = event;
        return this;
    }

    public OutcomingEventBuilder setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public OutcomingEventBuilder setUpdatedPlayers(List<PlayerEntity> updatedPlayers) {
        this.updatedPlayers = updatedPlayers;
        return this;
    }

    public OutcomingEventBuilder setUpdatedCards(List<CardEntity> updatedCards) {
        this.updatedCards = updatedCards;
        return this;
    }

    public OutcomingEvent createOutcomingEvent() {
        return new OutcomingEvent(event, gameId, updatedPlayers, updatedCards);
    }
}