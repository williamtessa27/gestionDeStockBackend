package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeClientDto {

    private String code;

    private Instant dateCommande;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
        if (commandeClient == null){
            return null;
        }

        return CommandeClientDto.builder()
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto) {
        if (commandeClientDto == null) {
            return null;
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setCode(commandeClientDto.getCode());
        commandeClient.setDateCommande(commandeClientDto.getDateCommande());

        return commandeClient;
    }
}
