package com.tessa.gestiondestock.services.impl;

import com.tessa.gestiondestock.dto.EntrepriseDto;
import com.tessa.gestiondestock.exception.EntityNotFoundException;
import com.tessa.gestiondestock.exception.ErrorCodes;
import com.tessa.gestiondestock.exception.InvalidEntityException;
import com.tessa.gestiondestock.model.Entreprise;
import com.tessa.gestiondestock.repository.EntrepriseRepository;
import com.tessa.gestiondestock.services.EntrepriseService;
import com.tessa.gestiondestock.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private final EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Entreprise is not Valid{}", dto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALID, errors);
        }
        return EntrepriseDto.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDto.toEntity(dto)
                ));
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        if(id == null){
            log.error("Entreprise ID is null");
            return null;
        }

        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);


        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun avec l'ID = " + id + "n'a ete trouve dans la base de donnee",
                        ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Entreprise ID is null");
        }
        assert id != null;
        entrepriseRepository.deleteById(id);
    }
}
