package com.devlil0.todolist.todolist.dto;


import com.devlil0.todolist.todolist.enums.Priority;
import com.devlil0.todolist.todolist.enums.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskDTO {

    @NotBlank
    @Length(max = 30)
    private String name;

    @NotBlank
    @Length(max = 130)
    private String description;

    private LocalDateTime dueDate;

    private Status status;

    private Priority priority;





}