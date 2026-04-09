package com.devlil0.todolist.todolist.mapper;


import com.devlil0.todolist.todolist.database.model.TaskEntity;
import com.devlil0.todolist.todolist.database.repository.ITaskRepository;
import com.devlil0.todolist.todolist.dto.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final ITaskRepository taskRepository;

    public List<TaskDTO> toDTO(){

        List<TaskEntity> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTO = new ArrayList<>();

        for(TaskEntity task: tasks){

            taskDTO.add(TaskDTO.builder()
                    .name(task.getName())
                    .description(task.getDescription())
                    .build());

        }

        return taskDTO;
    }
}
