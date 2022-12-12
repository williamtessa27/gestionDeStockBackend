package com.tessa.gestiondestock.controller.api;

import com.tessa.gestiondestock.dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tessa.gestiondestock.utils.constants.APP_ROOT;

public interface ClientApi {

    @PostMapping(value =APP_ROOT + "/client/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/client/{idclient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDto findById(@PathVariable("idclient") Integer id);

    @GetMapping(value = APP_ROOT + "/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/client/delete/{idclient}")
    void delete(@PathVariable("idclient") Integer id);
}
