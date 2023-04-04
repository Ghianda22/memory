package com.memory.backend.livegame;

import com.memory.backend.exceptions.NotAllowedActionException;
import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.livegame.data.enums.ClientEvent;
import com.memory.backend.livegame.data.request.IncomingEvent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class LivegameDelegate {
    private LiveGameService liveGameService;

    @Autowired
    public LivegameDelegate(LiveGameService liveGameService) {
        this.liveGameService = liveGameService;
    }

    public void handleEvent(IncomingEvent event) {
        try {
            switch (event.getEvent()) {
                case START_GAME -> startGame(event.getPlayerId());
                case TURN_CARD -> {
                }
                case QUIT_GAME -> {
                }
                default -> throw new EnumConstantNotPresentException(ClientEvent.class, event.getEvent().toString());
            }
        } catch (NotAllowedActionException | NotFoundOnDbException | EnumConstantNotPresentException e) {

        }
    }

    void startGame(UUID playerId) throws NotAllowedActionException, NotFoundOnDbException {
        if (!liveGameService.validateStartAction(playerId)) {
            throw new NotAllowedActionException();
        }
        liveGameService.startGameAnyway(playerId);
    }

    void turnCard(UUID playerId) {

    }

    void quitGame(UUID playerId) {

    }
}
