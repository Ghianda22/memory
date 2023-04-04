package com.memory.backend.livegame.data.request;

import com.memory.backend.livegame.data.enums.ClientEvent;

import java.util.UUID;

public class IncomingEvent {
    private ClientEvent event;
    private UUID playerId;
    private UUID cardId;

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
