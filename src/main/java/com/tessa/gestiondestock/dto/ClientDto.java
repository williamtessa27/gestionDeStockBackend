package com.tessa.gestiondestock.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessa.gestiondestock.model.Adresse;
import com.tessa.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numtel;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public ClientDto fromEntity(Client client){
        if (client == null){
            return null;
        }

        return ClientDto.builder()
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numtel(client.getNumtel())
                .build();
    }

    public Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }

        Client client = new Client();
        client.setNom(clientDto.getNom());
        client.setPrenom(clientDto.getPrenom());
        client.setPhoto(clientDto.getPhoto());
        client.setMail(clientDto.getMail());
        client.setNumtel(clientDto.getNumtel());

        return client;
    }
}
