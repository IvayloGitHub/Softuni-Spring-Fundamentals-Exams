package com.example.gira.service;

import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTask(TaskServiceModel taskServiceModel);

    List<TaskViewModel> getAllTasks();

    void progress(Long id);
}
