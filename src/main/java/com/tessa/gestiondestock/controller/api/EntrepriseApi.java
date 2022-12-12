package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

public interface EntrepriseApi {

    @PostMapping(value =APP_ROOT + "/entreprise/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(value = APP_ROOT + "/entreprise/{identreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDto findById(@PathVariable("identreprise") Integer id);

    @GetMapping(value = APP_ROOT + "/entreprise/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/entreprise/delete/{identreprise}")
    void delete(@PathVariable("identreprise") Integer id);
}
