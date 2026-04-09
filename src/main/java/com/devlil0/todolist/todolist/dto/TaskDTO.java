package com.devlil0.todolist.todolist.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

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

}