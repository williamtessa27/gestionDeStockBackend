package com.tessa.gestiondestock.dto;

import com.tessa.gestiondestock.model.Article;
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
}
