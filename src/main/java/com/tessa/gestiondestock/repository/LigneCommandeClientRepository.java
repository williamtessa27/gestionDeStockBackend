package com.tessa.gestiondestock.repository;

import com.tessa.gestiondestock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
    Optional<LigneCommandeClient> findAllByCommandeClientId(Integer idCommande);
}
