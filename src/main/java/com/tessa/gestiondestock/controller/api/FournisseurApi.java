package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.ArticleDto;
import com.tessa.gestiondestock.dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

public interface FournisseurApi {

    @PostMapping(value =APP_ROOT + "/fournisseur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(value = APP_ROOT + "/articles/{idfournisseur}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDto findById(@PathVariable("idfournisseur") Integer id);

    @GetMapping(value = APP_ROOT + "/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/fournisseur/delete/{idfournisseur}")
    void delete(@PathVariable("idfournisseur") Integer id);
}
