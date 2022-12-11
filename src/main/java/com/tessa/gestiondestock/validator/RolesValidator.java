package com.tessa.gestiondestock.validator;

import com.tessa.gestiondestock.dto.RolesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDto rolesDto){
        List<String> errors = new ArrayList<>();

        if (rolesDto == null){
            errors.add("Veuillez renseigner un role");
            return errors;
        }

        if (!StringUtils.hasLength(rolesDto.getRoleName())){
            errors.add("Veuillez renseigner un role");
        }
        return errors;
    }
}
