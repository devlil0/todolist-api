package com.devlil0.todolist.todolist.service;

import com.devlil0.todolist.todolist.database.model.TaskEntity;
import com.devlil0.todolist.todolist.database.repository.ITaskRepository;
import com.devlil0.todolist.todolist.dto.TaskDTO;
import com.devlil0.todolist.todolist.dto.TaskResponseDTO;
import com.devlil0.todolist.todolist.exception.NotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@RequiredArgsConstructor
public class TaskService {

    private final ITaskRepository taskRepository;

    public void createTask(TaskDTO dto){
        TaskEntity task = TaskEntity.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();

        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void updateTask(TaskDTO dto, Long id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

        task.setName(dto.getName());
        task.setDescription(dto.getDescription());

        taskRepository.save(task);
    }

    public TaskResponseDTO findById(Long id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setOverDue(task.isOverdue());
        dto.setCreatedAt(task.getCreatedAt());
        dto.setUpdateAt(task.getUpdateAt());

        return dto;
    }
}
