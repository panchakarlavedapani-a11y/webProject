package com.worknestapp.service;

import com.worknestapp.dao.TaskDAO;
import com.worknestapp.dao.TaskDAOImpl;
import com.worknestapp.model.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskDAO taskDAO = new TaskDAOImpl();

    @Override
    public void create(Task task) { taskDAO.save(task); }

    @Override
    public void update(Task task) { taskDAO.update(task); }

    @Override
    public Task findById(Long id) { return taskDAO.findById(id); }

    @Override
    public List<Task> listAll() { return taskDAO.findAll(); }

    @Override
    public List<Task> listByUser(Long userId) { return taskDAO.findByUserId(userId); }
}
