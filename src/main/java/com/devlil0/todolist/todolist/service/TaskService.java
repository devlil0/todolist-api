package com.devlil0.todolist.todolist.service;

import com.devlil0.todolist.todolist.database.model.TaskEntity;
import com.devlil0.todolist.todolist.database.repository.ITaskRepository;
import com.devlil0.todolist.todolist.dto.TaskDTO;
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
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));

        task.setName(dto.getName());
        task.setDescription(dto.getDescription());

        taskRepository.save(task);
    }

    public TaskDTO findById(Long id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));

        return TaskDTO.builder()
                .name(task.getName())
                .description(task.getDescription())
                .build();
    }
}
