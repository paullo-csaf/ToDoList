package com.example.todolist.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.model.Task;
import com.example.todolist.model.TaskStatus;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByUserIdAndStatus(Long userId, TaskStatus status);
    List<Task> findByUserIdAndDeadlineBefore(Long userId, LocalDate deadline);
}

