package com.tessa.gestiondestock.services;

import com.tessa.gestiondestock.dto.ArticleDto;
import com.tessa.gestiondestock.dto.LigneCommandeClientDto;
import com.tessa.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.tessa.gestiondestock.dto.LigneVenteDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto dto);

    ArticleDto findById(Integer id);

    ArticleDto findByCodeArticle(String codeArticle);

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticleDto> findAllArticleByIdCategory(Integer idCategory);

    List<ArticleDto> findAll();

    void delete(Integer id);
}
