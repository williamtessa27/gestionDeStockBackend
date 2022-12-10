package com.tessa.gestiondestock.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvtstk")
public class MvtStk extends AbstractEntity{

    @Column(name = "dateMvt")
    private Instant dateMvt;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "typemvt")
    private typeMvtStk typeMvt;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;


}
