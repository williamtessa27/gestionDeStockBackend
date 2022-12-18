package com.tessa.gestiondestock.dto;



import com.tessa.gestiondestock.model.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;

    private Integer idEntreprise;

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if (ligneCommandeFournisseur == null){
            return null;
            //TODO throw on exception
        }

        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
                .build();
    }


    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        if (ligneCommandeFournisseurDto == null){
            return null;
            //TODO throw on exception
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseurDto.getId());
        ligneCommandeFournisseur.setIdEntreprise(ligneCommandeFournisseurDto.getIdEntreprise());
        ligneCommandeFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseur()));
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));

        return ligneCommandeFournisseur;
    }

}
