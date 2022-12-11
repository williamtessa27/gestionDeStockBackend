package com.tessa.gestiondestock.dto;


import com.tessa.gestiondestock.model.MvtStk;
import com.tessa.gestiondestock.model.typeMvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtStkDto {

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDto article;

    private typeMvtStk typeMvt;

    public static MvtStkDto fromEntity(MvtStk mvtStk){
        if (mvtStk == null){
            return null;
            //TODO throw on exception
        }

        return MvtStkDto.builder()
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .build();
    }


    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if (mvtStkDto == null){
            return null;
            //TODO throw on exception
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());

        return mvtStk;
    }
}
