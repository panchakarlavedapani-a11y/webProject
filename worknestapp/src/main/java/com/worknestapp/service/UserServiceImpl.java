package com.worknestapp.service;

import com.worknestapp.dao.UserDAO;
import com.worknestapp.dao.UserDAOImpl;
import com.worknestapp.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void register(User user) { userDAO.save(user); }

    @Override
    public User login(String username, String password) {
        User u = userDAO.findByUsername(username);
        if(u!=null && u.getPassword().equals(password)) return u;
        return null;
    }

    @Override
    public List<User> listAll() { return userDAO.findAll(); }

    @Override
    public User findById(Long id) { return userDAO.findById(id); }

    @Override
    public void delete(Long id) { userDAO.delete(id); }
}
