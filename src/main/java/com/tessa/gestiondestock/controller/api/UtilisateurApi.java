package com.tessa.gestiondestock.controller.api;


import com.tessa.gestiondestock.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

@Api(APP_ROOT + "/utilisateurs")
public interface UtilisateurApi {

    @PostMapping(APP_ROOT + "/utilisateurs/create")
    UtilisateurDto save(@RequestBody UtilisateurDto dto);

    @GetMapping("/utilisateurs/{idUtilisateur}")
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(APP_ROOT + "/utilisateurs/all")
    List<UtilisateurDto> findAll();

    @DeleteMapping(APP_ROOT + "/utilisateurs/delete/{idUtilisateur}")
    void delete(@PathVariable("idUtilisateur") Integer id);
}
