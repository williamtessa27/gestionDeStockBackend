package com.tessa.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tessa.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private String code;

    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;

    public CategoryDto fromEntity(Category category){
        if (category == null){
            return null;
            //TODO throw on exception
        }

    return CategoryDto.builder()
            .code(category.getCode())
            .designation(category.getDesignation())
            .build();
    }


    public Category toEntity(CategoryDto categoryDto){
        if (categoryDto == null){
            return null;
            //TODO throw on exception
        }

        Category category = new Category();
         category.setCode(categoryDto.getCode());
         category.setDesignation(categoryDto.getDesignation());

         return category;
    }
}
