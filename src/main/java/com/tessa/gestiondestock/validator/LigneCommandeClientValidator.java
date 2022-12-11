package com.tessa.gestiondestock.validator;


import com.tessa.gestiondestock.dto.LigneCommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
        List<String> errors = new ArrayList<>();

        if(ligneCommandeClientDto == null){
            errors.add("Veuillez renseigner la quantite de la ligne de commande client");
            errors.add("Veuillez renseigner le prix unitaire de la ligne de commande client");
            return errors;
        }

        if (!StringUtils.hasLength((CharSequence) ligneCommandeClientDto.getQuantite())){
            errors.add("Veuillez renseigner la quantite de la ligne de commande client");
        }

        if (!StringUtils.hasLength((CharSequence) ligneCommandeClientDto.getPrixUnitaire())){
            errors.add("Veuillez renseigner le prix unitaire de la ligne de commande client");
        }
        return errors;
    }
}
