package com.memory.backend.game;

import com.memory.backend.game.data.GameEntity;
import com.memory.backend.game.data.enums.GameStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends CrudRepository<GameEntity, UUID> {
    List<GameEntity> findAllByStatusAndIsPublicTrue(GameStatus gameStatus);
}
