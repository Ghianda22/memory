package com.memory.backend.livegame.data.response;

import com.memory.backend.cards.data.persistence.CardEntity;
import com.memory.backend.livegame.data.enums.ServerEvent;
import com.memory.backend.player.data.persistence.PlayerEntity;

import java.util.List;

public final class OutcomingEvent {
    private final ServerEvent event;
    private final String gameId;
    private final List<PlayerEntity> updatedPlayers;
    private final List<CardEntity> updatedCards;

    OutcomingEvent(ServerEvent event, String gameId, List<PlayerEntity> updatedPlayers, List<CardEntity> updatedCards) {
        this.event = event;
        this.gameId = gameId;
        this.updatedPlayers = updatedPlayers;
        this.updatedCards = updatedCards;
    }

    public ServerEvent getEvent() {
        return event;
    }

    public String getGameId() {
        return gameId;
    }

    public List<PlayerEntity> getUpdatedPlayers() {
        return updatedPlayers;
    }

    public List<CardEntity> getUpdatedCards() {
        return updatedCards;
    }
}
