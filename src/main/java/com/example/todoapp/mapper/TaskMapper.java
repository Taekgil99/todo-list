package com.example.todoapp.mapper;

import com.example.todoapp.dto.TaskDto;
import com.example.todoapp.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {
    Task taskPostDtoToTask(TaskDto.Post requestBody);
    Task taskPatchDtoToTask(TaskDto.Patch requestBody);
    TaskDto.Response taskToTasksResponse(Task task);
}
