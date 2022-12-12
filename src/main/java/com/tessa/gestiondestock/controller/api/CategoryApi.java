package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.ArticleDto;
import com.tessa.gestiondestock.dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

public interface CategoryApi {

    @PostMapping(value =APP_ROOT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/category/{idcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable("idcategory") Integer id);

    @GetMapping(value = APP_ROOT + "/category/{codecategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable("codecategory") String code);

    @GetMapping(value = APP_ROOT + "/category/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/category/delete/{idcategory}")
    void delete(@PathVariable("idcategory") Integer id);
}
