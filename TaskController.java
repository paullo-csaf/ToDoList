package com.example.todolist.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.model.Task;
import com.example.todolist.model.User;
import com.example.todolist.service.TaskService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(taskService.getTasksByUser(user.getId()));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}