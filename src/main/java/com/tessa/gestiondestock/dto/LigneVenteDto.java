package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private VentesDto vente;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public static LigneVenteDto fromEntity(LigneVente ligneVente){
        if (ligneVente == null){
            return null;
            //TODO throw on exception
        }

        return LigneVenteDto.builder()
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .build();
    }


    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if (ligneVenteDto == null){
            return null;
            //TODO throw on exception
        }

        LigneVente ligneVente = new LigneVente();
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());

        return ligneVente;
    }

}
