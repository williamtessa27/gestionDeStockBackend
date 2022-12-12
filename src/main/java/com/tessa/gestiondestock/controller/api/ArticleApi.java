package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

public interface ArticleApi {

    @PostMapping(value =APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{idarticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idarticle") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{codearticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codearticle") String code);

    @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idarticle}")
    void delete(@PathVariable("idarticle") Integer id);
}
