package com.devlil0.todolist.todolist.controller;

import com.devlil0.todolist.todolist.dto.TaskDTO;
import com.devlil0.todolist.todolist.dto.TaskResponseDTO;
import com.devlil0.todolist.todolist.enums.Priority;
import com.devlil0.todolist.todolist.mapper.TaskMapper;
import com.devlil0.todolist.todolist.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskMapper taskMapper;
    private final TaskService taskService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TaskResponseDTO> findAll(){
        return taskMapper.toDTO();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponseDTO findTask(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@Valid @RequestBody TaskDTO dto){
        taskService.createTask(dto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@Valid @RequestBody TaskDTO dto, @PathVariable Long id){
        taskService.updateTask(dto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @GetMapping("/{id}/done")
    @ResponseStatus(HttpStatus.OK)
    public void updateStatus(@PathVariable Long id){
        taskService.updateStatus(id);
    }

    @PatchMapping("/{id}/priority")
    @ResponseStatus(HttpStatus.OK)
    public void updatePriority(@PathVariable Long id, @RequestParam Priority priority){
        taskService.updatePriority(id, priority);
    }

}
