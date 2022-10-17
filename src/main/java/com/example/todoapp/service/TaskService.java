package com.example.todoapp.service;

import com.example.todoapp.entity.Task;
import com.example.todoapp.exception.BusinessLogicException;
import com.example.todoapp.exception.ExceptionCode;
import com.example.todoapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public Task addTask(Task task) {
        Task savedTask = taskRepository.save(task);
        return savedTask;
    }

    public Task updateTask(Task task) {
        Task findTask = findVerifiedMember(task.getTaskId());

        Optional.ofNullable(task.getTitle())
                .ifPresent(title -> findTask.setTitle(title));
        Optional.ofNullable(task.getOrder())
                .ifPresent(order -> findTask.setOrder(order));
        Optional.ofNullable(task.getCompleted())
                .ifPresent(completed -> findTask.setCompleted(completed));

        return taskRepository.save(findTask);
    }

    public Task findTask(Long taskId) {
        return findVerifiedMember(taskId);
    }

    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public void deleteAllTask() {
        taskRepository.deleteAll();
    }

    public Task findVerifiedMember(long tasksId) {
        Optional<Task> optionalMember =
                taskRepository.findById(tasksId);
        Task findTask =
                optionalMember.orElseThrow(() ->
                        new BusinessLogicException(ExceptionCode.TASKS_NOT_FOUND));
        return findTask;
    }



}
