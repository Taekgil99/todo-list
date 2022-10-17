package com.example.todoapp.mapper;

import com.example.todoapp.dto.TasksDto;
import com.example.todoapp.entity.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TasksMapper {
    Task taskPostDtoToTasks(TasksDto.Post taskDto);
    Task taskPatchDtoToTasks(TasksDto.Patch taskDto);
    TasksDto.Response taskToTasksResponse(Task task);
    List<TasksDto.Response> tasksToMemberResponses(List<Task> tasks);
}
