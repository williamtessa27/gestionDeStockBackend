package com.tessa.gestiondestock.validator;

import com.tessa.gestiondestock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors = new ArrayList<>();

        if (commandeFournisseurDto == null){
            errors.add("Veuillez renseigner le code de la commande fournisseur");
            errors.add("Veuillez renseigner la date de la commande du fournisseur");
            return errors;
        }

        if (!StringUtils.hasLength(String.valueOf(commandeFournisseurDto.getCode()))){
            errors.add("Veuillez renseigner le code de la commande du fournisseur");
        }

        if (!StringUtils.hasLength(String.valueOf(commandeFournisseurDto.getDateCommande()))){
            errors.add("Veuillez renseigner la date de la commande du fournisseur");
        }

        return errors;
    }
}
