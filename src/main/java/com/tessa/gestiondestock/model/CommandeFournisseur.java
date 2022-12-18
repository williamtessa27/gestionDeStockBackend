package com.tessa.gestiondestock.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "commandefournisseur")
public class CommandeFournisseur extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "datecommande")
    private Instant dateCommande;

    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandeFournisseur")
    @ToString.Exclude
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CommandeFournisseur that = (CommandeFournisseur) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
