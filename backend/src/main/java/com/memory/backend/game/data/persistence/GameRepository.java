package com.memory.backend.game.data.persistence;

import com.memory.backend.game.data.enums.GameStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<GameEntity, UUID> {
    List<GameEntity> findAllByStatusAndIsPublicTrue(GameStatus gameStatus);
}
