package com.tessa.gestiondestock.dto;

import com.tessa.gestiondestock.model.Adresse;


import java.util.List;

public class ClientDto {

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String numTel;

    private String mail;

    private List<CommandeClientDto> commandeClients;

}
