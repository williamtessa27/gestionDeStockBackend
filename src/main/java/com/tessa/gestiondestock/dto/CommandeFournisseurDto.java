package com.tessa.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessa.gestiondestock.model.CommandeFournisseur;
import com.tessa.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private Integer id;

    private Integer idEntreprise;

    private String code;

    private EtatCommande etatCommande;

    private Instant dateCommande;

    private FournisseurDto fournisseur;

    @JsonIgnore
    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur == null){
            return null;
        }

        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .etatCommande(commandeFournisseur.getEtatCommande())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto) {
        if (commandeFournisseurDto == null) {
            return null;
        }

        CommandeFournisseur commandeFournisseur = new CommandeFournisseur();
        commandeFournisseur.setId(commandeFournisseurDto.getId());
        commandeFournisseur.setIdEntreprise(commandeFournisseurDto.getIdEntreprise());
        commandeFournisseur.setEtatCommande(commandeFournisseurDto.getEtatCommande());
        commandeFournisseur.setCode(commandeFournisseurDto.getCode());
        commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
        commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));

        return commandeFournisseur;
    }

    public boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
