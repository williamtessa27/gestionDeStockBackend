package com.tessa.gestiondestock.repository;

import com.tessa.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
}
