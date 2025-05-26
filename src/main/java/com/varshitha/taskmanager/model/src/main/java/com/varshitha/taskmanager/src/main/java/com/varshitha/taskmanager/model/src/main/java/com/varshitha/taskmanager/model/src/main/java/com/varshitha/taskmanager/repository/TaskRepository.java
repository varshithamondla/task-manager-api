package com.varshitha.taskmanager.repository;

import com.varshitha.taskmanager.model.Task;
import com.varshitha.taskmanager.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}
Added task.java
