package com.tessa.gestiondestock.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lignevente")
public class LigneVente extends AbstractEntity{

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idvente")
    private Ventes vente;

    @Column(name = "idquantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;
}
