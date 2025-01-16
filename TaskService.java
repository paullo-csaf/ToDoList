package com.example.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}