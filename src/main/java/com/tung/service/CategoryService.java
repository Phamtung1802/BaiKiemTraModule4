package com.tung.service;
import com.tung.model.Category;
import com.tung.model.User;

public interface CategoryService {
    Iterable<Category> findAll();
    Category findFirstById(Long id);
    void save(Category category);
}
