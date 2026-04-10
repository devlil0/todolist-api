package com.devlil0.todolist.todolist.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskResponseDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDate createdAt;

    private LocalDate updateAt;

    private boolean overDue;

}