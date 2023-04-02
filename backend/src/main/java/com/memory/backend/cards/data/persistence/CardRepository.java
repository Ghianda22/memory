package com.memory.backend.cards.data.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends JpaRepository<CardEntity, UUID> {
    List<CardEntity> findAllByGameId(UUID gameId);
    List<CardEntity> findAllByGameIdAndIsFaceUpTrueAndIsCollectedFalse(UUID gameId);
}
