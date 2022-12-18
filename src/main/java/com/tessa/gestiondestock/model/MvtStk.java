package com.tessa.gestiondestock.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "mvtstk")
public class MvtStk extends AbstractEntity{

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "datemvt")
    private Instant dateMvt;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "typemvt")
    private typeMvtStk typeMvt;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MvtStk mvtStk = (MvtStk) o;
        return getId() != null && Objects.equals(getId(), mvtStk.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
