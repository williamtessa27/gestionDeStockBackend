package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.FournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

@Api(APP_ROOT + "/fournisseurs")
public interface FournisseurApi {

    @PostMapping(APP_ROOT + "/fournisseurs/create")
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(APP_ROOT + "/fournisseurs/{idFournisseur}")
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(APP_ROOT + "/fournisseurs/all")
    List<FournisseurDto> findAll();

    @DeleteMapping(APP_ROOT + "/fournisseurs/delete/{idFournisseur}")
    void delete(@PathVariable("idFournisseur") Integer id);
}
