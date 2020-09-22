package com.tung.repository;

import com.tung.model.Category;
import com.tung.model.User;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    public Category findFirstById(Long id);
}
