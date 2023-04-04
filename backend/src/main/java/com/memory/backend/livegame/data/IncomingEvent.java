package com.memory.backend.livegame.data;

import com.memory.backend.livegame.data.enums.ClientEvent;

import java.util.UUID;

public class IncomingEvent {
    private ClientEvent event;
    private UUID playerId;
    /**
     *  cardId
     *
     * */
    private Object payload;
}
