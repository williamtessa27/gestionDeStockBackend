package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.Category;
import com.tessa.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class UtilisateurDto {

    private String nom;

    private String prenom;

    private String mail;

    private Instant dateDeNaissance;

    private String motDePasse;

    private AdresseDto adresse;

    private String photo;

    private EntrepriseDto entreprise;

    private List<RolesDto> roles;

    public UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
            //TODO throw on exception
        }

        return UtilisateurDto.builder()
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .mail(utilisateur.getMail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .motDePasse(utilisateur.getMotDePasse())
                .photo(utilisateur.getPhoto())
                .build();
    }

    public Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null){
            return null;
            //TODO throw on exception
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setMail(utilisateurDto.getMail());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setPhoto(utilisateurDto.getPhoto());

        return utilisateur;
    }
}
