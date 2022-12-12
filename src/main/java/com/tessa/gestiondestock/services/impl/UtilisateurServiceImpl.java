package com.tessa.gestiondestock.services.impl;


import com.tessa.gestiondestock.dto.UtilisateurDto;
import com.tessa.gestiondestock.exception.EntityNotFoundException;
import com.tessa.gestiondestock.exception.ErrorCodes;
import com.tessa.gestiondestock.exception.InvalidEntityException;
import com.tessa.gestiondestock.model.Utilisateur;
import com.tessa.gestiondestock.repository.UtilisateurRepository;
import com.tessa.gestiondestock.services.UtilisateurService;
import com.tessa.gestiondestock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Utilisateur is not Valid{}", dto);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }
        return UtilisateurDto.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDto.toEntity(dto)
                ));

    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if(id == null){
            log.error("Utilisateur ID is null");
            return null;
        }

        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);


        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun avec l'ID = " + id + "n'a ete trouve dans la base de donnee",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Utilisateur ID is null");
        }
        assert id != null;
        utilisateurRepository.deleteById(id);
    }
}
