package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class VentesDto {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    public static VentesDto fromEntity(Ventes ventes){
        if (ventes == null){
            return null;
            //TODO throw on exception
        }

        return VentesDto.builder()
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
        ventes.setCode(ventesDto.getCode());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCommentaire(ventesDto.getCommentaire());

        return ventes;
    }

}
