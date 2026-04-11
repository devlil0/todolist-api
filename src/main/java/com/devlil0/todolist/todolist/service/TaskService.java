package com.devlil0.todolist.todolist.service;

import com.devlil0.todolist.todolist.database.model.TaskEntity;
import com.devlil0.todolist.todolist.database.repository.ITaskRepository;
import com.devlil0.todolist.todolist.dto.TaskDTO;
import com.devlil0.todolist.todolist.dto.TaskResponseDTO;
import com.devlil0.todolist.todolist.enums.Priority;
import com.devlil0.todolist.todolist.enums.Status;
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
        TaskEntity task = new TaskEntity();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setOverDue(task.isOverdue());

        taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void updateTask(TaskDTO dto, Long id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());

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
        dto.setUpdatedAt(task.getUpdatedAt());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());

        return dto;
    }

    public void updateStatus(Long id){

        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

        task.setStatus(Status.DONE);

        taskRepository.save(task);
    }

    public void updatePriority(Long id, Priority priority){

        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

        task.setPriority(priority);

        taskRepository.save(task);
    }
}
