package io.HEPL.dossierFinalSysDist.repositories;

import io.HEPL.dossierFinalSysDist.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
