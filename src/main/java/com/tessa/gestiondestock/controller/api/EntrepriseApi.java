package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.EntrepriseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

@Api(APP_ROOT + "/entreprises")
public interface EntrepriseApi {

    @PostMapping(APP_ROOT + "/entreprises/create")
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(APP_ROOT + "/entreprises/{identreprise}")
    EntrepriseDto findById(@PathVariable("identreprise") Integer id);

    @GetMapping(APP_ROOT + "/entreprises/all")
    List<EntrepriseDto> findAll();

    @DeleteMapping(APP_ROOT + "/entreprises/delete/{identreprise}")
    void delete(@PathVariable("identreprise") Integer id);
}
