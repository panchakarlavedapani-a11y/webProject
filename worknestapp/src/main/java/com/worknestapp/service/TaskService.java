package com.worknestapp.service;

import com.worknestapp.model.Task;
import java.util.List;

public interface TaskService {
    void create(Task task);
    void update(Task task);
    Task findById(Long id);
    List<Task> listAll();
    List<Task> listByUser(Long userId);
}
