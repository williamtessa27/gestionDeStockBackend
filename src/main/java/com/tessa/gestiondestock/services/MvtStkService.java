package com.tessa.gestiondestock.services;

import com.tessa.gestiondestock.dto.MvtStkDto;

import java.util.List;

public interface MvtStkService {

    MvtStkDto save(MvtStkDto dto);

    MvtStkDto findById(Integer id);

    List<MvtStkDto> findAll();

    void delete(Integer id);

}
