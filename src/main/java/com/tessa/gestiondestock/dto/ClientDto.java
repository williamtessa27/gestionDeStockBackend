package com.tessa.gestiondestock.dto;



import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class ClientDto {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String numTel;

    private String mail;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

}
