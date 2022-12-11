package com.tessa.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;


@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @CreatedDate
    @Column(name = "creation", nullable = false)
    @JsonIgnore
    private Instant creationDate;

    @LastModifiedDate
    @Column(name = "lastmodifieddate")
    @JsonIgnore
    private Instant lastModifiedDate;
}
