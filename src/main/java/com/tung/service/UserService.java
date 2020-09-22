package com.tung.service;
import com.tung.model.Category;
import com.tung.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserService {
    Iterable<User> findAll();
    User findFirstById(Long id);
    void save(User user);
    Iterable<User> findAllByCategory_Id(Category id);
    public void delete(User user);

}
