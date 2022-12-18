package com.tessa.gestiondestock.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


@Getter
@Setter
@ToString
@Entity
@Table(name = "lignecommandeclient")
public class LigneCommandeClient extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idcommandeclient")
    private CommandeClient commandeClient;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LigneCommandeClient that = (LigneCommandeClient) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
