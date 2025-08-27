package com.worknestapp.dao;

import com.worknestapp.model.Task;
import java.util.List;

public interface TaskDAO {
    void save(Task task);
    void update(Task task);
    Task findById(Long id);
    List<Task> findAll();
    List<Task> findByUserId(Long userId);
}
