package com.memory.backend.game;

import com.memory.backend.game.data.GameEntity;
import com.memory.backend.game.data.enums.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameEntity> getActiveGames() {
        return gameRepository.findAllByGameStatusAndIsGamePublicTrue(GameStatus.PENDING);
    }

    public void saveNewGame(GameEntity newGame){
        gameRepository.save(newGame);
    }



}
