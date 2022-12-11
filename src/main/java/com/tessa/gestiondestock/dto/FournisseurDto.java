package com.tessa.gestiondestock.dto;

import com.tessa.gestiondestock.model.Adresse;
import com.tessa.gestiondestock.model.Category;
import com.tessa.gestiondestock.model.Fournisseur;
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

    public FournisseurDto fromEntity(Fournisseur fournisseur){
        if (fournisseur == null){
            return null;
            //TODO throw on exception
        }

        return FournisseurDto.builder()
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .adresse(fournisseur.getAdresse())
                .photo(fournisseur.getPhoto())
                .numTel(fournisseur.getNumTel())
                .mail(fournisseur.getNumTel())
                .build();
    }


    public Fournisseur toEntity(FournisseurDto fournisseurDto){
        if (fournisseurDto == null){
            return null;
            //TODO throw on exception
        }

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setAdresse(fournisseurDto.getAdresse());
        fournisseur.setPhoto(fournisseurDto.getPhoto());
        fournisseur.setNumTel(fournisseurDto.getNumTel());
        fournisseur.setMail(fournisseurDto.getMail());

        return fournisseur;
    }
}
