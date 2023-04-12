package com.memory.backend.livegame;

import com.memory.backend.cards.service.CardService;
import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.game.data.enums.GameStatus;
import com.memory.backend.game.services.GameService;
import com.memory.backend.player.data.persistence.PlayerEntity;
import com.memory.backend.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LiveGameService {

    private final GameService gameService;
    private final PlayerService playerService;
    private final CardService cardService;

    @Autowired
    public LiveGameService(GameService gameService, PlayerService playerService, CardService cardService) {
        this.gameService = gameService;
        this.playerService = playerService;
        this.cardService = cardService;
    }


//    --- DB MANAGEMENT ----------------------------------------------------------------------------
    public void startGame(UUID gameId){
        gameService.updateGameStatusById(gameId, GameStatus.IN_PROGRESS);
        cardService.createDeckForGame(gameId);
        changeTurnPlayer(gameId);
    }

    //    --- DATA CHECKS --------------------------------------------------------------
    public Boolean validateStartAction(UUID playerId) {
        if (!playerService.isPlayerAdmin(playerId)) {
            return false;
        }
        UUID gameId = playerService.getPlayerWithId(playerId).getGameId();
        if(playerService.getPlayersInGameWithId(gameId).size() < 1) {
            return false;
        }
        return gameService.validateGameStatus(gameId, GameStatus.PENDING);
    }




//    --- GAME LOGICS --------------------------------------------------------------------

    public void clientStartsGame(UUID adminId) {
        UUID gameId = playerService.getPlayerWithId(adminId).getGameId();
//        call here the validation admin method
        startGame(gameId);
    }

    public void changeTurnPlayer(UUID gameId) {
        List<PlayerEntity> playersInGame = playerService.getPlayersInGameWithId(gameId);

        Integer turnPlayerIndex = 0;
        for (int i = 0; i < playersInGame.size(); i++) {
            if (playersInGame.get(i).getIsTurnPlayer()) {
                turnPlayerIndex = i;
            }
        }
        playersInGame.get(turnPlayerIndex).setTurnPlayer(false);
        playersInGame.get(turnPlayerIndex + 1).setTurnPlayer(true);
    }

    public void doCardsMatch() {
    }

    public void calculateRanking() {
    }

}
