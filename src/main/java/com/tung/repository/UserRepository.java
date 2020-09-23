package com.tung.repository;

import com.tung.model.Category;
import com.tung.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findFirstById(Long id);
    Iterable<User> findAllByCategory_Id(Category category_id);
}
