package com.memory.backend.invitations.emails.data.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface InvitationRepository extends JpaRepository<InvitationEntity, UUID> {
    InvitationEntity findByGameId(UUID gameId);
}
