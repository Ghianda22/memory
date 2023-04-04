package com.memory.backend.livegame.data.request;

import com.memory.backend.livegame.data.enums.ClientEvent;

import java.util.UUID;

public class IncomingEventBuilder {
    private ClientEvent event;
    private UUID playerId;
    private UUID cardId;

    public IncomingEventBuilder setEvent(ClientEvent event) {
        this.event = event;
        return this;
    }

    public IncomingEventBuilder setPlayerId(UUID playerId) {
        this.playerId = playerId;
        return this;
    }

    public IncomingEventBuilder setCardId(UUID cardId) {
        this.cardId = cardId;
        return this;
    }

    public IncomingEvent createIncomingEvent() {
        return new IncomingEvent(event, playerId, cardId);
    }
}