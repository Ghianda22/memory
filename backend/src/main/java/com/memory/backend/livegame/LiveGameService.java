package com.memory.backend.livegame;

import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.game.data.enums.GameStatus;
import com.memory.backend.game.services.GameService;
import com.memory.backend.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class LiveGameService {

    private final GameService gameService;
    private final PlayerService playerService;

    @Autowired
    public LiveGameService(GameService gameService, PlayerService playerService) {
        this.gameService = gameService;
        this.playerService = playerService;
    }

//    --- DB MANAGEMENT ----------------------------------------------------------------------------
    public void startGame(UUID playerId) throws NotFoundOnDbException {
        UUID gameId = playerService.getPlayerWithId(playerId).getGameId();
        gameService.updateGameStatusById(gameId, GameStatus.IN_PROGRESS);
    }


//    --- DATA CHECKS --------------------------------------------------------------
    public Boolean validateStartAction(UUID playerId){
        if (!isPlayerAdmin(playerId)){
            return false;
        }
        UUID gameId = playerService.getPlayerWithId(playerId).getGameId();
        return gameService.validateGameStatus(gameId, GameStatus.PENDING);
    }
    public Boolean isPlayerAdmin(UUID playerId){
        return playerService.getPlayerWithId(playerId).getIsAdmin();
    }
    public Boolean isTurnPlayer(UUID playerId){
        return playerService.getPlayerWithId(playerId).getIsTurnPlayer();
    }


    public void calculateRanking(){}
    public void changeTurnPlayer(){}
    public void doCardsMatch(){}
}
