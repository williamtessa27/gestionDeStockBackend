package com.tessa.gestiondestock.validator;


import com.tessa.gestiondestock.dto.LigneVenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto ligneVenteDto) {
        List<String> errors = new ArrayList<>();

        if (ligneVenteDto == null) {
            errors.add("Veuillez renseigner la quantite de la ligne de vente");
            errors.add("Veuillez renseigner le prix unitaire de la ligne de vente");
            return errors;
        }

        if (!StringUtils.hasLength((CharSequence) ligneVenteDto.getQuantite())) {
            errors.add("Veuillez renseigner la quantite de la ligne de vente");
        }

        if (!StringUtils.hasLength((CharSequence) ligneVenteDto.getPrixUnitaire())) {
            errors.add("Veuillez renseigner le prix unitaire de la ligne de vente");
        }
        return errors;
    }
}
