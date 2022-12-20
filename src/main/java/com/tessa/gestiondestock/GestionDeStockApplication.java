package com.tessa.gestiondestock;

import com.tessa.gestiondestock.model.Article;
import com.tessa.gestiondestock.model.Category;
import com.tessa.gestiondestock.repository.ArticleRepository;
import com.tessa.gestiondestock.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class GestionDeStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDeStockApplication.class, args);
    }
}
