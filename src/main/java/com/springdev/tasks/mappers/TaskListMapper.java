package com.springdev.tasks.mappers;

import com.springdev.tasks.domain.dto.TaskListDto;
import com.springdev.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);

}
