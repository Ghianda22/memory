package com.memory.backend.livegame.data.request;

import com.memory.backend.livegame.data.enums.ClientEvent;

import java.util.UUID;

public final class IncomingEvent {
    private final ClientEvent event;
    private final UUID playerId;
    private final UUID cardId;

    IncomingEvent(ClientEvent event, UUID playerId, UUID cardId) {
        this.event = event;
        this.playerId = playerId;
        this.cardId = cardId;
    }

    public ClientEvent getEvent() {
        return event;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public UUID getCardId() {
        return cardId;
    }
}
