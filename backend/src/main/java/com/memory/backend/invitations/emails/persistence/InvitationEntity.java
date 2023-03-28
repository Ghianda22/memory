package com.memory.backend.invitations.emails.persistence;

import com.memory.backend.BaseEntity;
import com.memory.backend.Icons;
import jakarta.persistence.*;

import java.util.UUID;


@Entity
@Table(name = "Invitation")
public class InvitationEntity extends BaseEntity {
    private UUID gameId;
    private Icons avatar;
    private InvitationStatus status;

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

//    TODO: absolutely fix this aberrant infraction of the immutability
    public void setStatus(InvitationStatus status) {
        this.status = status;
    }
}
