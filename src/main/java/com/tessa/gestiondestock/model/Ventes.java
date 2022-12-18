package com.tessa.gestiondestock.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "ventes")
public class Ventes extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "datevente")
    private Instant dateVente;

    @Column(name = "commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "vente")
    @ToString.Exclude
    private List<LigneVente> ligneVentes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ventes ventes = (Ventes) o;
        return getId() != null && Objects.equals(getId(), ventes.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
