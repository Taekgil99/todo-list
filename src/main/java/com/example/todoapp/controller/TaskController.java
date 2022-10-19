package com.example.todoapp.controller;

import com.example.todoapp.dto.MultiResponseDto;
import com.example.todoapp.dto.SingleResponseDto;
import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import com.example.todoapp.mapper.TaskMapper;
import com.example.todoapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(allowedHeaders ="*", origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping
@Slf4j
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper mapper;

    @Value("${server.service.url}")
    private String serviceUrl;

    @PostMapping("/")
    public ResponseEntity addTask(@RequestBody TaskDto.Post taskDto) {
        Task task = mapper.taskPostDtoToTask(taskDto);
        Task savedTask = taskService.addTask(task);
        TaskDto.Response response = mapper.taskToTasksResponse(savedTask);
        response.setUrl(serviceUrl);
        return new ResponseEntity<>(
                new SingleResponseDto<>(response), HttpStatus.CREATED
        );
    }

    @PatchMapping("/{task-id}")
    public ResponseEntity updateTask(@PathVariable("task-id") long taskId,
                                     @RequestBody TaskDto.Patch taskDto) {
        Task task = mapper.taskPatchDtoToTask(taskDto);
        task.setTaskId(taskId);
        Task updatedTask = taskService.updateTask(task);
        TaskDto.Response response = mapper.taskToTasksResponse(updatedTask);
        response.setUrl(serviceUrl);
        return new ResponseEntity(
                new SingleResponseDto<>(response), HttpStatus.OK
        );
    }

    @GetMapping("/{task-id}")
    public ResponseEntity getTask(@PathVariable("task-id") long taskId) {
        Task findTask = taskService.findTask(taskId);
        TaskDto.Response response = mapper.taskToTasksResponse(findTask);
        response.setUrl(serviceUrl);
        return new ResponseEntity(
                new SingleResponseDto<>(response), HttpStatus.OK
        );
    }

    @GetMapping
    public ResponseEntity getTasks() {
        List<Task> findTasks = taskService.findAllTask();

        List<TaskDto.Response> responses = findTasks.stream()
                .map(mapper::taskToTasksResponse)
                .collect(Collectors.toList());

        return new ResponseEntity(
                new MultiResponseDto<>(responses), HttpStatus.OK
        );
    }

    @DeleteMapping("/{task-id}")
    public ResponseEntity deleteTask(@PathVariable("task-id") long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllTask() {
        taskService.deleteAllTask();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
