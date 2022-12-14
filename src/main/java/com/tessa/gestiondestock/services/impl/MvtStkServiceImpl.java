package com.tessa.gestiondestock.services.impl;

import com.tessa.gestiondestock.dto.ClientDto;
import com.tessa.gestiondestock.dto.MvtStkDto;
import com.tessa.gestiondestock.exception.EntityNotFoundException;
import com.tessa.gestiondestock.exception.ErrorCodes;
import com.tessa.gestiondestock.exception.InvalidEntityException;
import com.tessa.gestiondestock.model.Client;
import com.tessa.gestiondestock.model.MvtStk;
import com.tessa.gestiondestock.repository.MvtStkRepository;
import com.tessa.gestiondestock.services.MvtStkService;
import com.tessa.gestiondestock.validator.ClientValidator;
import com.tessa.gestiondestock.validator.MvtStkValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MvtStkServiceImpl implements MvtStkService {

    private final MvtStkRepository mvtStkRepository;

    @Autowired
    public MvtStkServiceImpl(MvtStkRepository mvtStkRepository) {
        this.mvtStkRepository = mvtStkRepository;
    }

    @Override
    public MvtStkDto save(MvtStkDto dto) {
        List<String> errors = MvtStkValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("MvtStkDto is not Valid{}", dto);
            throw new InvalidEntityException("Le MvtStkDto n'est pas valide", ErrorCodes.MVT_STK_NOT_VALID, errors);
        }
        return MvtStkDto.fromEntity(
                mvtStkRepository.save(
                        MvtStkDto.toEntity(dto)
                ));
    }

    @Override
    public MvtStkDto findById(Integer id) {
        if(id == null){
            log.error("MvtStk ID is null");
            return null;
        }

        Optional<MvtStk> mvtStk = mvtStkRepository.findById(id);


        return Optional.of(MvtStkDto.fromEntity(mvtStk.get())).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun avec l'ID = " + id + "n'a ete trouve dans la base de donnee",
                        ErrorCodes.MVT_STK_NOT_FOUND)
        );
    }

    @Override
    public List<MvtStkDto> findAll() {
            return mvtStkRepository.findAll().stream()
                    .map(MvtStkDto::fromEntity)
                    .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Client ID is null");
        }
        assert id != null;
        mvtStkRepository.deleteById(id);
    }
}
