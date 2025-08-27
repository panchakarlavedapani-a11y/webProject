package com.worknestapp.service;

import com.worknestapp.model.User;
import java.util.List;

public interface UserService {
    void register(User user);
    User login(String username, String password);
    List<User> listAll();
    User findById(Long id);
    void delete(Long id);
}
