package com.tessa.gestiondestock.controller.api;


import com.tessa.gestiondestock.dto.VentesDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

@Api(APP_ROOT + "/ventes")
public interface VentesApi {

    @PostMapping("/ventes/create")
    VentesDto save(@RequestBody VentesDto dto);

    @GetMapping("/ventes/{idVente}")
    VentesDto findById(@PathVariable("idVente") Integer id);

    @GetMapping("/ventes/{codeVente}")
    VentesDto findByCode(@PathVariable("codeVente") String code);

    @GetMapping("/ventes/all")
    List<VentesDto> findAll();

    @DeleteMapping("/ventes/delete/{idVente}")
    void delete(@PathVariable("idVente") Integer id);
}
