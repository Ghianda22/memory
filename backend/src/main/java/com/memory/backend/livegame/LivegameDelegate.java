package com.memory.backend.livegame;

import com.memory.backend.exceptions.NotAllowedActionException;
import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.livegame.data.enums.ClientEvent;
import com.memory.backend.livegame.data.request.IncomingEvent;
import com.memory.backend.livegame.data.response.OutcomingEvent;
import com.memory.backend.livegame.data.response.OutcomingEventBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LivegameDelegate {
    private final LiveGameService liveGameService;
    private final LiveGameController liveGameController;

    @Autowired
    public LivegameDelegate(LiveGameService liveGameService, LiveGameController liveGameController) {
        this.liveGameService = liveGameService;
        this.liveGameController = liveGameController;
    }

    public void handleEvent(IncomingEvent event) {
        try {
            switch (event.getEvent()) {
                case START_GAME -> clientStartsGame(event.getPlayerId());
                case TURN_CARD -> turnCard(event.getPlayerId(), event.getCardId());
                case QUIT_GAME -> {
                }
                default -> throw new EnumConstantNotPresentException(ClientEvent.class, event.getEvent().toString());
            }
        } catch (NotAllowedActionException | NotFoundOnDbException | EnumConstantNotPresentException e) {

        }
    }
    public void sendEvent(OutcomingEvent event){
        liveGameController.send(event);
    }

    void clientStartsGame(UUID playerId) throws NotAllowedActionException, NotFoundOnDbException {
        if (!liveGameService.validateStartAction(playerId)) {
            throw new NotAllowedActionException();
        }
        liveGameService.clientStartsGame(playerId);
    }

    void turnCard(UUID playerId, UUID cardId) {
        /*
        * Get the player
        * get the game
        * check the game status "in progress"
        * get the card
        * check "is face up" = false
        * set "is face up" = true
        * get the game cards
        *   is face up = true
        *   is collected = false
        *
        *
        * */
    }

    void quitGame(UUID playerId) {

    }
}
