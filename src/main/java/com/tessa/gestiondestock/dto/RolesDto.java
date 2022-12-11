package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.Category;
import com.tessa.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

    private String roleName;

    private UtilisateurDto utilisateur;

    public RolesDto fromEntity(Roles roles){
        if (roles == null){
            return null;
            //TODO throw on exception
        }

        return RolesDto.builder()
                .roleName(roles.getRoleName())
                .build();
    }


    public Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return null;
            //TODO throw on exception
        }

        Roles roles = new Roles();
        roles.setRoleName(rolesDto.getRoleName());

        return roles;
    }
}
