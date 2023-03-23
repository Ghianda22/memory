package com.memory.backend.game.services;

import com.memory.backend.game.GameRepository;
import com.memory.backend.game.data.GameEntity;
import com.memory.backend.game.data.enums.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /**
     * This method has been extracted from the creation method to support future changes in the ID creation
     * Same reason is used to justify the manual id definition instead of including it directly into the class
     * */
    public String generateGameId(){
        return UUID.randomUUID().toString();
    }

    public List<GameEntity> getActiveGames() {
        return gameRepository.findAllByGameStatusAndIsGamePublicTrue(GameStatus.PENDING);
    }

    public void saveNewGame(GameEntity newGame){
        gameRepository.save(newGame);
    }



}
