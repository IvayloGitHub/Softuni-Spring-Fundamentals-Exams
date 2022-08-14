package com.example.gira.service.impl;

import com.example.gira.model.entity.TaskEntity;
import com.example.gira.model.entity.enums.ProgressEnum;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.model.view.TaskViewModel;
import com.example.gira.repository.TaskRepository;
import com.example.gira.sec.CurrentUser;
import com.example.gira.service.ClassificationService;
import com.example.gira.service.TaskService;
import com.example.gira.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final ClassificationService classificationService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, ClassificationService classificationService, UserService userService, CurrentUser currentUser) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.classificationService = classificationService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void addTask(TaskServiceModel taskServiceModel) {
        TaskEntity taskEntity = modelMapper.map(taskServiceModel, TaskEntity.class);
        taskEntity.setClassification(classificationService.findTaskByClassificationName(taskServiceModel.getClassification()));
        taskEntity.setUser(userService.findUserById(currentUser.getId()));
        taskEntity.setProgress(ProgressEnum.OPEN);
        taskRepository.save(taskEntity);
    }

    @Override
    public List<TaskViewModel> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskEntity -> {
                    TaskViewModel taskViewModel = modelMapper.map(taskEntity, TaskViewModel.class);
                    taskViewModel.setClassification(taskEntity.getClassification().getName());
                    taskViewModel.setUsername(taskEntity.getUser().getUsername());
                    return taskViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void progress(Long id) {
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElse(null);
        if (taskEntity != null) {
            ProgressEnum progressEnum = taskEntity.getProgress();
            switch (progressEnum) {
                case OPEN -> taskEntity.setProgress(ProgressEnum.IN_PROGRESS);
                case IN_PROGRESS -> taskEntity.setProgress(ProgressEnum.COMPLETED);
                case COMPLETED -> taskEntity.setProgress(ProgressEnum.OTHER);
            }
            if (taskEntity.getProgress() == ProgressEnum.OTHER) {
                taskRepository.deleteById(id);
            } else {
                taskRepository.save(taskEntity);
            }

        }
    }
}
