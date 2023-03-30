package com.memory.backend.player.service;

import com.memory.backend.Icons;
import com.memory.backend.game.data.enums.GameStatus;
import com.memory.backend.game.services.GameService;
import com.memory.backend.player.data.persistence.PlayerEntity;
import com.memory.backend.player.data.persistence.PlayerEntityBuilder;
import com.memory.backend.player.data.persistence.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final GameService gameService;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, GameService gameService) {
        this.playerRepository = playerRepository;
        this.gameService = gameService;
    }


    //    --- DB MANAGEMENT --------------------------------------------------------------
    public UUID savePlayer(UUID gameId) {
        PlayerEntity player = new PlayerEntityBuilder()
                .setGameId(gameId)
                .createPlayerEntity();
        return playerRepository.save(player).getId();
    }

    public UUID saveAdmin(UUID gameId, Icons adminAvatar) {
        PlayerEntity player = new PlayerEntityBuilder()
                .setGameId(gameId)
                .setAvatar(adminAvatar)
                .setIsAdmin(true)
                .createPlayerEntity();
        UUID adminId = playerRepository.save(player).getId();
        if(adminId != null){
            gameService.updateGameStatusById(gameId);
        }
    }

    public List<PlayerEntity> getPlayersInGameWithId(UUID gameId) {
        return playerRepository.findAllByGameId(gameId);
    }

    ;

    public void getPlayer() {
    }

    ;


    //    --- DATA CONTROLS -------------------------------------------
    public Boolean isGameCreated(UUID gameID){
        return gameService.validateGameStatus(gameID, GameStatus.CREATED);
    }

    public Boolean isGameActive(UUID gameID){
        return gameService.validateGameStatus(gameID, GameStatus.PENDING);
    }

    public Boolean isGameFull(UUID gameId){
        Integer gameCapacity = gameService.getGameMaxNumberOfPlayers(gameId);
        if(gameCapacity == null){
            return null;
        }
        List<PlayerEntity> playerInGame = getPlayersInGameWithId(gameId);
        if(playerInGame.isEmpty()) {
            return null;
        }
        if (playerInGame.size() == gameCapacity){
            return false;
        }
        return false;

    }



    public void validatePlayerAction() {
//        is turn player?
//        is the game started?
    }

    ;

    public void calculateRankingInGameWithId() {
    }

}
