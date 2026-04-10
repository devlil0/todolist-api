package com.devlil0.todolist.todolist.mapper;


import com.devlil0.todolist.todolist.database.model.TaskEntity;
import com.devlil0.todolist.todolist.database.repository.ITaskRepository;
import com.devlil0.todolist.todolist.dto.TaskResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ITaskRepository taskRepository;

    public List<TaskResponseDTO> toDTO(){

        List<TaskEntity> tasks = taskRepository.findAll();
        List<TaskResponseDTO> taskDTO = new ArrayList<>();

        for(TaskEntity task: tasks){

            TaskResponseDTO dto = new TaskResponseDTO();
            dto.setId(task.getId());
            dto.setName(task.getName());
            dto.setDescription(task.getDescription());
            dto.setOverDue(task.isOverdue());
            dto.setCreatedAt(task.getCreatedAt());
            dto.setUpdateAt(task.getUpdateAt());
        }

        return taskDTO;
    }
}
