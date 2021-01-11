package io.HEPL.dossierFinalSysDist.services;

import io.HEPL.dossierFinalSysDist.models.Article;
import io.HEPL.dossierFinalSysDist.repositories.ArticleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository productRepository;

    public ArticleServiceImpl(ArticleRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Article> getAll() {

        return (List<Article>) productRepository.findAll();

    }

    @Override
    public Article findById(int id) {

        Article p = productRepository.findById(id).orElse(null);

        return p;

    }

    @Override
    public Article findByName(String name) {

        return productRepository.getByName(name);


    }
}
