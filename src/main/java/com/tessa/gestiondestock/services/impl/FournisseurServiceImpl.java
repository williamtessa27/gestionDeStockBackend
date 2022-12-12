package com.tessa.gestiondestock.services.impl;

import com.tessa.gestiondestock.dto.FournisseurDto;
import com.tessa.gestiondestock.exception.EntityNotFoundException;
import com.tessa.gestiondestock.exception.ErrorCodes;
import com.tessa.gestiondestock.exception.InvalidEntityException;
import com.tessa.gestiondestock.model.Fournisseur;
import com.tessa.gestiondestock.repository.FournisseurRepository;
import com.tessa.gestiondestock.services.FournisseurService;
import com.tessa.gestiondestock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Fournisseur is not Valid{}", dto);
            throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }
        return FournisseurDto.fromEntity(
                fournisseurRepository.save(
                        FournisseurDto.toEntity(dto)
                ));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if(id == null){
            log.error("Fournisseur ID is null");
            return null;
        }

        Optional<Fournisseur> article = fournisseurRepository.findById(id);


        return Optional.of(FournisseurDto.fromEntity(article.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun avec l'ID = " + id + "n'a ete trouve dans la base de donnee",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Fournisseur ID is null");
        }
        assert id != null;
        fournisseurRepository.deleteById(id);
    }
}
