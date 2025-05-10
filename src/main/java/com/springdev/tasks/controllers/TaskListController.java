package com.springdev.tasks.controllers;

import com.springdev.tasks.domain.dto.TaskListDto;
import com.springdev.tasks.domain.entities.TaskList;
import com.springdev.tasks.mappers.TaskListMapper;
import com.springdev.tasks.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists")
@CrossOrigin(origins = "https://task-list-app-frontend.onrender.com")
public class TaskListController {

    private final TaskListService taskListService;

    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    // GET /task-lists
    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskList()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    // POST /task-list
    @PostMapping
    public TaskListDto createTaskList(
            @RequestBody TaskListDto taskListDto
    ) {
        TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );

        return taskListMapper.toDto(createdTaskList);
    }

    // GET /task-list/{task_list_id}
    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDto> getTaskList(
            @PathVariable("task_list_id")UUID taskListId
    ) {
        return taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }

    // PUT /task-list/{task_list_id}
    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskListDto taskListDto
    ) {
        TaskList updateTaskList =  taskListService.updateTaskList(
                taskListId,
                taskListMapper.fromDto(taskListDto)
        );

        return taskListMapper.toDto(updateTaskList);
    }

    // DELETE /task-list/{task_list_id}
    @DeleteMapping(path = "/{task_list_id}")
    public void deleteTaskList(
            @PathVariable("task_list_id") UUID taskListId
    ) {
        taskListService.deleteTaskList(taskListId);
    }
}
