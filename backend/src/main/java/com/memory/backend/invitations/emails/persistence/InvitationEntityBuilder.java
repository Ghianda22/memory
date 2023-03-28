package com.memory.backend.invitations.emails.persistence;

import com.memory.backend.Icons;

import java.util.UUID;

public class InvitationEntityBuilder {
    private UUID gameId;
    private Icons avatar;
    private InvitationStatus status = InvitationStatus.PENDING;

    public InvitationEntityBuilder setGameId(UUID gameId) {
        this.gameId = gameId;
        return this;
    }

    public InvitationEntityBuilder setAvatar(Icons avatar) {
        this.avatar = avatar;
        return this;
    }

    public InvitationEntityBuilder setStatus(InvitationStatus status) {
        this.status = status;
        return this;
    }

    public InvitationEntity createInvitationEntity() {
        return new InvitationEntity(gameId, avatar, status);
    }
}