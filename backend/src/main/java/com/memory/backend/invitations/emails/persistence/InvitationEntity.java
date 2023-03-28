package com.memory.backend.invitations.emails.persistence;

import com.memory.backend.BaseEntity;
import com.memory.backend.Icons;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;


@Entity
public class InvitationEntity extends BaseEntity {
    private UUID gameId;
    private Icons avatar;
    private InvitationStatus status = InvitationStatus.PENDING;

    public InvitationEntity() {
    }

    InvitationEntity(UUID gameId, Icons avatar, InvitationStatus status) {
        this.gameId = gameId;
        this.avatar = avatar;
        this.status = status;
    }

    public UUID getGameId() {
        return gameId;
    }

    public Icons getAvatar() {
        return avatar;
    }

    public InvitationStatus getStatus() {
        return status;
    }

    private void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    private void setAvatar(Icons avatar) {
        this.avatar = avatar;
    }

    private void setStatus(InvitationStatus status) {
        this.status = status;
    }
}
