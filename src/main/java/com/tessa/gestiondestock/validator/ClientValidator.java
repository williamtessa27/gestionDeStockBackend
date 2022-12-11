package com.tessa.gestiondestock.validator;

import com.tessa.gestiondestock.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le prenom du client");
            errors.add("Veuillez renseigner le mail du client");
            errors.add("Veuillez renseigner le numero de telephone du client");
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getNom())){
            errors.add("Veuillez renseigner le nom du client");
        }

        if (!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Veuillez renseigner le prenom du client");
        }

        if (!StringUtils.hasLength(clientDto.getMail())){
            errors.add("Veuillez renseigner le mail du client");
        }

        if (!StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("Veuillez renseigner le numero de telephone du client");
        }

        return errors;
    }
}
