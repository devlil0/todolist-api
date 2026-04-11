package com.devlil0.todolist.todolist.dto;


import com.devlil0.todolist.todolist.enums.Priority;
import com.devlil0.todolist.todolist.enums.Status;
import lombok.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskResponseDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean overDue;

    private Status status;

    private Priority priority;

}