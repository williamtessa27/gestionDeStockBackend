package com.tessa.gestiondestock.dto;

import com.tessa.gestiondestock.model.Adresse;
import com.tessa.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;

    private String nom;

    private String description;

    private AdresseDto adresse;

    private String codeFiscal;

    private String photo;

    private String mail;

    private String numTel;

    private String siteWeb;

    private List<UtilisateurDto> utilisateurs;
}
