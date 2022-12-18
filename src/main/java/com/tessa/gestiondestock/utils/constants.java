package com.tessa.gestiondestock.utils;


public interface constants {

    String APP_ROOT = "gestiondestock/v1";
    
    String COMMANDE_FOURNISSEUR_ENDPOINT = APP_ROOT + "/commandesfournisseurs";

    String CREATE_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/create";

    String FIND_COMMANDE_FOURNISSEUR_BY_ID_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/{idCommandeFournisseur}";

    String FIND_COMMANDE_FOURNISSEUR_BY_CODE_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/{codeCommandeFournisseur}";

    String FIND_ALL_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/all";

    String DELETE_COMMANDE_FOURNISSEUR_ENDPOINT = COMMANDE_FOURNISSEUR_ENDPOINT + "/delete/{idCommandeFournisseur}";

    String AUTHENTIFICATION_END_POINT = APP_ROOT + "/auth";
}
