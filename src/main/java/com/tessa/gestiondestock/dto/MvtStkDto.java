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

    private Integer id;

    private Integer idEntreprise;

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
                .id(mvtStk.getId())
                .idEntreprise(mvtStk.getIdEntreprise())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .article(ArticleDto.fromEntity(mvtStk.getArticle()))
                .build();
    }


    public static MvtStk toEntity(MvtStkDto mvtStkDto){
        if (mvtStkDto == null){
            return null;
            //TODO throw on exception
        }

        MvtStk mvtStk = new MvtStk();
        mvtStk.setId(mvtStkDto.getId());
        mvtStk.setIdEntreprise(mvtStkDto.getIdEntreprise());
        mvtStk.setDateMvt(mvtStkDto.getDateMvt());
        mvtStk.setQuantite(mvtStkDto.getQuantite());
        mvtStk.setArticle(ArticleDto.toEntity(mvtStkDto.getArticle()));

        return mvtStk;
    }
}
