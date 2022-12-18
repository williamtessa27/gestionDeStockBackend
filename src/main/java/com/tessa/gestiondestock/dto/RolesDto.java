package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.Roles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolesDto {

    private Integer id;

    private Integer idEntreprise;

    private String roleName;

    private UtilisateurDto utilisateur;

    public static RolesDto fromEntity(Roles roles){
        if (roles == null){
            return null;
            //TODO throw on exception
        }

        return RolesDto.builder()
                .id(roles.getId())
                .idEntreprise(roles.getIdEntreprise())
                .roleName(roles.getRoleName())
                .build();
    }


    public static Roles toEntity(RolesDto rolesDto){
        if (rolesDto == null){
            return null;
            //TODO throw on exception
        }

        Roles roles = new Roles();
        roles.setId(rolesDto.getId());
        roles.setIdEntreprise(rolesDto.getIdEntreprise());
        roles.setRoleName(rolesDto.getRoleName());

        return roles;
    }
}
