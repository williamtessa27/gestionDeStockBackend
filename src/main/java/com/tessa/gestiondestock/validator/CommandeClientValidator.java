package com.tessa.gestiondestock.validator;

import com.tessa.gestiondestock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public static List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();

        if (commandeClientDto == null){
            errors.add("Veuillez renseigner le code de la commande client");
            return errors;
        }

        if (!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("Veuillez renseigner le code de la commande du client");
        }

        return errors;
    }
}
