package io.HEPL.dossierFinalSysDist.services;

import io.HEPL.dossierFinalSysDist.models.Category;
import io.HEPL.dossierFinalSysDist.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {

        return categoryRepository.findById(id).orElse(null);

    }
}
