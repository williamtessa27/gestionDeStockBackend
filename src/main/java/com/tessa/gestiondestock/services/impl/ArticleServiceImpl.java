package com.tessa.gestiondestock.services.impl;

import com.tessa.gestiondestock.dto.ArticleDto;
import com.tessa.gestiondestock.exception.EntityNotFoundException;
import com.tessa.gestiondestock.exception.ErrorCodes;
import com.tessa.gestiondestock.exception.InvalidEntityException;
import com.tessa.gestiondestock.model.Article;
import com.tessa.gestiondestock.repository.ArticleRepository;
import com.tessa.gestiondestock.services.ArticleService;
import com.tessa.gestiondestock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Article is not Valid{}", dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity(dto)
                ));
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("Article ID is null");
            return null;
        }

        Optional<Article> article = articleRepository.findById(id);


        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
        new EntityNotFoundException(
                "Aucun avec l'ID = " + id + "n'a ete trouve dans la base de donnee",
                ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Article code is null");
            return null;
        }

        Optional<Article> article = articleRepository.findArticleByCodeArticle(code);

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun avec le CODE = " + code + " n'a ete trouve dans la base de donnee",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Article ID is null");
        }
        assert id != null;
        articleRepository.deleteById(id);
    }
}
