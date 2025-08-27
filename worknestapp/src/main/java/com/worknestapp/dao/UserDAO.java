package com.worknestapp.dao;

import com.worknestapp.model.User;
import java.util.List;

public interface UserDAO {
    void save(User user);
    void update(User user);
    User findById(Long id);
    User findByUsername(String username);
    List<User> findAll();
    void delete(Long id);
}
