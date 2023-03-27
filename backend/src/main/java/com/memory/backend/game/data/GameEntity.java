package com.memory.backend.game.data;

import com.memory.backend.BaseEntity;
import com.memory.backend.game.data.enums.GameBgImage;
import com.memory.backend.game.data.enums.GameDifficulty;
import com.memory.backend.game.data.enums.GameStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table
public class GameEntity extends BaseEntity {
    @Id
    private UUID id;
    private GameStatus status;
    private String name;
    private GameBgImage bgImage;
    private GameDifficulty difficulty;
    private Integer maxNumberOfPlayers;
    private Boolean isPublic;

    public GameEntity() {}

    public GameEntity(UUID id, GameStatus status, String name, GameBgImage bgImage, GameDifficulty difficulty, Integer maxNumberOfPlayers, Boolean isPublic) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.bgImage = bgImage;
        this.difficulty = difficulty;
        this.maxNumberOfPlayers = maxNumberOfPlayers;
        this.isPublic = isPublic;
    }

    public UUID getId() {
        return id;
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public GameBgImage getBgImage() {
        return bgImage;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public Integer getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

//    had to modify the name to make hibernate recognize this as a getter
    public Boolean getIsPublic() {
        return isPublic;
    }
}
