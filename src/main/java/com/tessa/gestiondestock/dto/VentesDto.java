package com.tessa.gestiondestock.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessa.gestiondestock.model.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VentesDto {

    private String code;

    private Integer id;

    private Instant dateVente;

    private String commentaire;

    private List<LigneVenteDto> ligneVentes;

    @JsonIgnore
    public static VentesDto fromEntity(Ventes ventes){
        if (ventes == null){
            return null;
            //TODO throw on exception
        }

        return VentesDto.builder()
                .id(ventes.getId())
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
        ventes.setCode(ventesDto.getCode());
        ventes.setDateVente(ventesDto.getDateVente());
        ventes.setCommentaire(ventesDto.getCommentaire());

        return ventes;
    }

}
