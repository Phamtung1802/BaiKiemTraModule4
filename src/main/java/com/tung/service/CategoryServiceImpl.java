package com.tung.service;

import com.tung.model.Category;
import com.tung.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findFirstById(Long id) {
        return categoryRepository.findFirstById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }
}
