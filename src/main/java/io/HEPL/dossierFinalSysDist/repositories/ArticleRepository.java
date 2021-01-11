package io.HEPL.dossierFinalSysDist.repositories;

import io.HEPL.dossierFinalSysDist.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Article getByName(String name);
}
