package com.tessa.gestiondestock.dto;

import com.tessa.gestiondestock.model.Category;
import com.tessa.gestiondestock.model.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto {

    private ArticleDto article;

    private CommandeClientDto commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if (ligneCommandeClient == null){
            return null;
            //TODO throw on exception
        }

        return LigneCommandeClientDto.builder()
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .build();
    }


    public LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if (ligneCommandeClientDto == null){
            return null;
            //TODO throw on exception
        }

        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());

        return ligneCommandeClient;
    }
}
