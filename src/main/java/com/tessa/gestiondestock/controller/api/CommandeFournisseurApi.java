package com.tessa.gestiondestock.controller.api;


import com.tessa.gestiondestock.dto.CommandeClientDto;
import com.tessa.gestiondestock.dto.CommandeFournisseurDto;
import com.tessa.gestiondestock.dto.LigneCommandeClientDto;
import com.tessa.gestiondestock.dto.LigneCommandeFournisseurDto;
import com.tessa.gestiondestock.model.EtatCommande;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static com.tessa.gestiondestock.utils.constants.*;

@Api(COMMANDE_FOURNISSEUR_ENDPOINT)
public interface CommandeFournisseurApi {

    @PostMapping(CREATE_COMMANDE_FOURNISSEUR_ENDPOINT)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @PatchMapping(APP_ROOT + "//commandesfournisseurs/update/etat/{idCommandeFournisseur}/{etatCommande}")
    CommandeFournisseurDto updateEtatCommande(@PathVariable("idCommandeFournisseur") Integer idCommande,
                                                         @PathVariable("etatCommande") EtatCommande etatCommande);

    @PatchMapping(APP_ROOT + "//commandesfournisseurs/update/quantite/{idCommandeFournisseur}/{idLigneCommande}/{quantite}")
    CommandeFournisseurDto updateQuantiteCommande(
            @PathVariable("idCommandeFournisseur") Integer idCommande,
            @PathVariable("idLigneCommande") Integer idLigneCommande,
            @PathVariable("quantite") BigDecimal quantite);

    @PatchMapping(APP_ROOT + "/commandesfournisseurs/update/article/{idCommandeFournisseur}/{idLigneCommande}/{idArticle}")
    CommandeFournisseurDto updateArticle(@PathVariable("idCommandeFournisseur") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande,
                                                    @PathVariable("idArticle") Integer idArticle);

    @PatchMapping(APP_ROOT + "/commandesfournisseurs/update/fournisseur/{idCommandeFournisseur}/{idFournisseur}")
    CommandeFournisseurDto updateFournisseur(@PathVariable("idCommandeFournisseur") Integer idCommande,
                                                   @PathVariable("idFournisseur") Integer idFournisseur);

    @DeleteMapping(APP_ROOT + "/commandesfournisseurs/delete/article/{idCommandeFournisseur}/{idLigneCommande}")
    CommandeFournisseurDto deleteArticle(@PathVariable("idCommandeFournisseur") Integer idCommande,
                                                    @PathVariable("idLigneCommande") Integer idLigneCommande);

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT)
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT)
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur") String code);

    @GetMapping(FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT)
    List<CommandeFournisseurDto> findAll();

    @GetMapping(APP_ROOT + "/commandesfournisseurs/ligneCommande/{idCommandeFournisseur}")
    List<LigneCommandeFournisseurDto> findAllLigneCommandeFournisseurByCommandeFournisseurId(@PathVariable("idCommandeFournisseur") Integer idCommande);

    @DeleteMapping(DELETE_COMMANDE_FOURNISSEUR_ENDPOINT)
    void delete(@PathVariable("idCommandeFournisseur") Integer id);

}
