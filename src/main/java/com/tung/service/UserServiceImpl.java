package com.tung.service;
import com.tung.model.Category;
import com.tung.model.User;
import com.tung.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository UserRepository;


    @Override
    public Iterable<User> findAll() {
        return UserRepository.findAll();
    }

    @Override
    public User findFirstById(Long id) {
        return UserRepository.findFirstById(id);
    }

    @Override
    public void save(User user) {
        UserRepository.save(user);
    }

    @Override
    public Iterable<User> findAllByCategory_Id(Category id) {
        return UserRepository.findAllByCategory_Id(id);
    }

    @Override
    public void delete(User user) {
        UserRepository.delete(user);
    }
}
