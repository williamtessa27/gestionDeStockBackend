package com.tessa.gestiondestock.services.impl;


import com.tessa.gestiondestock.dto.ClientDto;
import com.tessa.gestiondestock.exception.EntityNotFoundException;
import com.tessa.gestiondestock.exception.ErrorCodes;
import com.tessa.gestiondestock.exception.InvalidEntityException;
import com.tessa.gestiondestock.model.Client;
import com.tessa.gestiondestock.repository.ClientRepository;
import com.tessa.gestiondestock.services.ClientService;
import com.tessa.gestiondestock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Client is not Valid{}", dto);
            throw new InvalidEntityException("Le Client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(
                clientRepository.save(
                        ClientDto.toEntity(dto)
                ));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null){
            log.error("Client ID is null");
            return null;
        }

        Optional<Client> client = clientRepository.findById(id);


        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun avec l'ID = " + id + "n'a ete trouve dans la base de donnee",
                        ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Client ID is null");
        }
        assert id != null;
        clientRepository.deleteById(id);
    }

}
