package com.memory.backend.game.services;

import com.memory.backend.game.data.persistence.GameRepository;
import com.memory.backend.game.data.persistence.GameEntity;
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

    public List<GameEntity> getActiveGames() {
        return gameRepository.findAllByStatusAndIsPublicTrue(GameStatus.PENDING);
    }

    public UUID saveNewGame(GameEntity newGame){
        return gameRepository.save(newGame).getId();
    }



}
