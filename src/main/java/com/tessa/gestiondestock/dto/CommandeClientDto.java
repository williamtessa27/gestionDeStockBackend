package com.tessa.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessa.gestiondestock.model.CommandeClient;
import com.tessa.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeClientDto {

    private Integer id;

    private Integer idEntreprise;

    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;

    private ClientDto client;

    @JsonIgnore
    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient == null){
            return null;
        }

        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .idEntreprise(commandeClient.getIdEntreprise())
                .code(commandeClient.getCode())
                .etatCommande(commandeClient.getEtatCommande())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setIdEntreprise(commandeClientDto.getIdEntreprise());
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setEtatCommande(commandeClientDto.getEtatCommande());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClient()));

        return commandeClient;
    }

    public boolean isCommandeLivree(){
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
