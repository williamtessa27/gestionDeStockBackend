package com.tessa.gestiondestock.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "roles")
public class Roles extends AbstractEntity{

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "rolename")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "idutilisateur")
    private Utilisateur utilisateur;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Roles roles = (Roles) o;
        return getId() != null && Objects.equals(getId(), roles.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
