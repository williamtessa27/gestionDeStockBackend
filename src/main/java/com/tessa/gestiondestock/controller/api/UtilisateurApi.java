package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.ArticleDto;
import com.tessa.gestiondestock.dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

public interface UtilisateurApi {


    @PostMapping(value =APP_ROOT + "/utilisateur/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping(value = APP_ROOT + "/utilisateur/{idutilisateur}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById(@PathVariable("idutilisateur") Integer id);

    @GetMapping(value = APP_ROOT + "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/utilisateur/delete/{idutilisateur}")
    void delete(@PathVariable("idutilisateur") Integer id);
}
