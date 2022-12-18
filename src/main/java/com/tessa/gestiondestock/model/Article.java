package com.tessa.gestiondestock.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "article")
public class Article extends AbstractEntity{

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaireHt;

    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<MvtStk> mvtStks;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Article article = (Article) o;
        return getId() != null && Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
