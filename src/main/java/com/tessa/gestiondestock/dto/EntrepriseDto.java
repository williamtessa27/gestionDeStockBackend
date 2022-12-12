package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.Category;
import com.tessa.gestiondestock.model.Entreprise;

import lombok.Builder;
import lombok.Data;


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

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if (entreprise == null){
            return null;
            //TODO throw on exception
        }

        return EntrepriseDto.builder()
                .nom(entreprise.getNom())
                .description(entreprise.getDescription())
                .codeFiscal(entreprise.getCodeFiscal())
                .photo(entreprise.getPhoto())
                .mail(entreprise.getMail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }


    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if (entrepriseDto == null){
            return null;
            //TODO throw on exception
        }

        Entreprise entreprise = new Entreprise();
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setDescription(entrepriseDto.getDescription());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setMail(entrepriseDto.getMail());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());

        return entreprise;
    }

}
