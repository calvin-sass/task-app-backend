package com.springdev.tasks.mappers;

import com.springdev.tasks.domain.dto.TaskDto;
import com.springdev.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);

}
