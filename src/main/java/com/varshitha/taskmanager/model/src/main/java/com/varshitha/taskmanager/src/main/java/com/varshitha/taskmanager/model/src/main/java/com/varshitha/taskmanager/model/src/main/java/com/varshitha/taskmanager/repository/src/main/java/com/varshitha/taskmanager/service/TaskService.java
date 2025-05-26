package com.varshitha.taskmanager.service;

import com.varshitha.taskmanager.model.Task;
import com.varshitha.taskmanager.model.TaskStatus;
import com.varshitha.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks(TaskStatus status) {
        if (status != null) {
            return taskRepository.findByStatus(status);
        }
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existing = getTask(id);
        if (existing != null) {
            existing.setTitle(updatedTask.getTitle());
            existing.setDescription(updatedTask.getDescription());
            existing.setStatus(updatedTask.getStatus());
            return taskRepository.save(existing);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
Added task.java
