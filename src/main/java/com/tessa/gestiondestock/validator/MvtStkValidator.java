package com.tessa.gestiondestock.validator;

import com.tessa.gestiondestock.dto.MvtStkDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {

    public static List<String> validate(MvtStkDto mvtStkDto){
        List<String> errors = new ArrayList<>();

        if (mvtStkDto == null){
            errors.add("Veuillez renseigner la quantite");
            errors.add("Veuillez renseigner le type de mouvement");
            return errors;
        }

        if (!StringUtils.hasLength((CharSequence) mvtStkDto.getQuantite())){
            errors.add("Veuillez renseigner la quantite");
        }

        if (!StringUtils.hasLength(String.valueOf(mvtStkDto.getTypeMvt()))){
            errors.add("Veuillez renseigner le type de mouvement");
        }

        return errors;
    }
}

