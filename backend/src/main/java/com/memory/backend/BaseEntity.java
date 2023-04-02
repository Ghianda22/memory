package com.memory.backend;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @CreationTimestamp
    private Date insertDate;
    @UpdateTimestamp
    private Date updateDate;
    @Version
    private Long version;

    public BaseEntity() {
    }

    public BaseEntity(UUID id, Date insertDate, Date updateDate, Long version) {
        this.id = id;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
        this.version = version;
    }

    public UUID getId() {
        return id;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public Long getVersion() {
        return version;
    }
}
