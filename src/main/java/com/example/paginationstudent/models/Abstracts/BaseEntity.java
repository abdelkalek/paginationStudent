package com.example.paginationstudent.models.Abstracts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author Abdelkhalek Guedri
 * @since 13/05/2023
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;


    @NotNull
    @CreatedBy
    @Column(name = "CREATOR", updatable = false)
    public Long creator;

    @NotNull
    @CreatedDate
    @Column(name = "CREATED", updatable = false)
    public Date created;

    @NotNull
    @LastModifiedBy
    @Column(name = "MODIFIER")
    public Long modifier;

    @NotNull
    @LastModifiedDate
    @Column(name = "MODIFIED")
    public Date modified;
}
