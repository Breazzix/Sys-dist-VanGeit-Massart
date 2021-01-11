package io.HEPL.dossierFinalSysDist.services;

import io.HEPL.dossierFinalSysDist.models.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();
    Article findById(int id);
    Article findByName(String name);
}
