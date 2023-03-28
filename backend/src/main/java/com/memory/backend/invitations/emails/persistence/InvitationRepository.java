package com.memory.backend.invitations.emails.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InvitationRepository extends CrudRepository<InvitationEntity, UUID> {
    InvitationEntity findByGameId(UUID gameId);
}
