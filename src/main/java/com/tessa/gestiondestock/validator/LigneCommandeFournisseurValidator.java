package com.tessa.gestiondestock.validator;


import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurValidator ligneCommandeFournisseurValidator){
        List<String> errors = new ArrayList<>();

        if(ligneCommandeFournisseurValidator == null){
            errors.add("Veuillez renseigner ce champ");
        }
        return errors;
    }
}
