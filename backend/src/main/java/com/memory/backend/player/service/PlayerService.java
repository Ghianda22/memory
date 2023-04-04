package com.memory.backend.player.service;

import com.memory.backend.Icons;
import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.game.data.enums.GameStatus;
import com.memory.backend.game.services.GameService;
import com.memory.backend.player.data.persistence.PlayerEntity;
import com.memory.backend.player.data.persistence.PlayerEntityBuilder;
import com.memory.backend.player.data.persistence.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return playerRepository.saveAndFlush(player).getId();
    }

    public UUID saveAdmin(UUID gameId, Icons adminAvatar) throws NotFoundOnDbException {
        PlayerEntity player = new PlayerEntityBuilder()
                .setGameId(gameId)
                .setAvatar(adminAvatar)
                .setIsAdmin(true)
                .createPlayerEntity();
        UUID adminId = playerRepository.saveAndFlush(player).getId();
        if(adminId != null){
            gameService.updateGameStatusById(gameId, GameStatus.PENDING);
        }
        return adminId;
    }

    public PlayerEntity getPlayerWithId(UUID playerId){
        Optional<PlayerEntity> optional = playerRepository.findById(playerId);
        if(optional.isEmpty()){
            return null;
        }
        return optional.get();
    }

    public List<PlayerEntity> getPlayersInGameWithId(UUID gameId) {
        return playerRepository.findAllByGameId(gameId);
    }




    //    --- DATA CHECKS -------------------------------------------
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
        return playerInGame.size() >= gameCapacity;

    }


    public void calculateRankingInGameWithId() {
    }

}
