package com.tessa.gestiondestock.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;
}
