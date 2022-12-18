package com.tessa.gestiondestock.controller.api;


import com.tessa.gestiondestock.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

@Api(APP_ROOT + "/clients")
public interface CommandeClientApi {

    @PostMapping(APP_ROOT + "/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @GetMapping(APP_ROOT + "/commandesClients/{idCommandesClient}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandesClient);

    @GetMapping(APP_ROOT + "/commandesclients/{codeCommandeClient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(APP_ROOT + "/commandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(APP_ROOT + "/commandesclients/delete/{idCommandeClient}")
    ResponseEntity delete(@PathVariable("idCommandeClient") Integer id);
}
