package com.tessa.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessa.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class VentesDto {

    private Integer id;

    private Integer idEntreprise;

    private String code;

    private Instant dateVente;

    private String commentaire;

    @JsonIgnore
    public static VentesDto fromEntity(Ventes ventes){
        if (ventes == null){
            return null;
            //TODO throw on exception
        }

        return VentesDto.builder()
                .id(ventes.getId())
                .idEntreprise(ventes.getIdEntreprise())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .build();
    }


    public static Ventes toEntity(VentesDto ventesDto){
        if (ventesDto == null){
            return null;
            //TODO throw on exception
        }

        Ventes ventes = new Ventes();
        ventes.setId(ventesDto.getId());
        ventes.setIdEntreprise(ventesDto.getIdEntreprise());
        ventes.setCode(ventesDto.getCode());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCommentaire(ventesDto.getCommentaire());

        return ventes;
    }

}
