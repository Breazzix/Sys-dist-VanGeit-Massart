package io.HEPL.dossierFinalSysDist.controllers;

import io.HEPL.dossierFinalSysDist.models.Category;
import io.HEPL.dossierFinalSysDist.services.CategoryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @RequestMapping("/categories")
    public String findCategories(Model model){

        List<Category> categories = categoryServiceImpl.getAll();

        model.addAttribute("categories",categories);

        return "category-list";

    }
    @RequestMapping("/category/{id}")
    public String getCategoryInfo(@PathVariable int id, Model model) {

        Category category = categoryServiceImpl.findById(id);

        model.addAttribute("category", category);

        return "category-info";
    }
}
