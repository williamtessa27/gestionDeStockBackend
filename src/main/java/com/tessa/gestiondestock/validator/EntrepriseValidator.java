package com.tessa.gestiondestock.validator;


import com.tessa.gestiondestock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();

        if (entrepriseDto == null){
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez renseigner la description de l'entreprise");
            errors.add("Veuillez renseigner le mail du client");
            errors.add("Veuillez renseigner le codefiscal de l'entreprise");
            errors.add("Veuillez renseigner le numero de telephone de l'entreprise");
            errors.add("Veuillez renseigner le siteweb de l'entreprise");
            return errors;
        }

        if (!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }

        if (!StringUtils.hasLength(entrepriseDto.getDescription())){
            errors.add("Veuillez renseigner la description de l'entreprise");
        }

        if (!StringUtils.hasLength(entrepriseDto.getMail())){
            errors.add("Veuillez renseigner le mail du client");
        }

        if (!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("Veuillez renseigner le codefiscal de l'entreprise");
        }

        if (!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Veuillez renseigner le numero de telephone de l'entreprise");
        }

        if (!StringUtils.hasLength(entrepriseDto.getSiteWeb())){
            errors.add("Veuillez renseigner le siteweb de l'entreprise");
        }

        return errors;
    }
}
