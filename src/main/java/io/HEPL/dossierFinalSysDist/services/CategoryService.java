package io.HEPL.dossierFinalSysDist.services;

import io.HEPL.dossierFinalSysDist.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category findById(int id);
}
