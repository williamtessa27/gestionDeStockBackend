package com.tessa.gestiondestock.dto;

import com.tessa.gestiondestock.model.Adresse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private String nom;

    private String prenom;

    private Adresse adresse;

    private String photo;

    private String numTel;

    private String mail;

    private List<CommandeFournisseurDto> commandeFournisseurs;
}
