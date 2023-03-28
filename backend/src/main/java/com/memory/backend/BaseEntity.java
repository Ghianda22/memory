package com.memory.backend;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@Entity
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @CreatedDate
    private Instant insertDate;
    @LastModifiedDate
    private Instant updateDate;
    @Version
    private Long version;

    public BaseEntity() {
    }

    public BaseEntity(UUID id, Instant insertDate, Instant updateDate, Long version) {
        this.id = id;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public Instant getInsertDate() {
        return insertDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public Long getVersion() {
        return version;
    }
}
