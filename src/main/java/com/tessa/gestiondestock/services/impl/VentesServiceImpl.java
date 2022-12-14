package com.tessa.gestiondestock.services.impl;

import com.tessa.gestiondestock.dto.VentesDto;
import com.tessa.gestiondestock.repository.ArticleRepository;
import com.tessa.gestiondestock.repository.LigneVenteRepository;
import com.tessa.gestiondestock.repository.VentesRepository;
import com.tessa.gestiondestock.services.VentesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {

    private final ArticleRepository articleRepository;
    private final VentesRepository ventesRepository;
    private final LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VentesServiceImpl(ArticleRepository articleRepository,
                             VentesRepository ventesRepository,
                             LigneVenteRepository ligneVenteRepository) {
        this.articleRepository = articleRepository;
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        return null;
    }

    @Override
    public VentesDto findById(Integer id) {
        return null;
    }

    @Override
    public VentesDto findByCode(String code) {
        return null;
    }

    @Override
    public List<VentesDto> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
