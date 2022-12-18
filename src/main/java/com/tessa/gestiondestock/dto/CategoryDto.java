package com.tessa.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessa.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private Integer idEntreprise;

    private String code;

    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category){
        if (category == null){
            return null;
            //TODO throw on exception
        }

    return CategoryDto.builder()
            .id(category.getId())
            .code(category.getCode())
            .idEntreprise(category.getIdEntreprise())
            .designation(category.getDesignation())
            .build();
    }


    public static Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
            //TODO throw on exception
        }

        Category category = new Category();
         category.setId(categoryDto.getId());
         category.setCode(categoryDto.getCode());
         category.setIdEntreprise(categoryDto.getIdEntreprise());
         category.setDesignation(categoryDto.getDesignation());

         return category;
    }
}
