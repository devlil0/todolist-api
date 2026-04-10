package com.devlil0.todolist.todolist.database.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Table(name = "task_entity")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(max = 30)
    private String name;

    @NotBlank
    @Length(max = 130)
    private String description;


    private LocalDate dueDate;



    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updateAt;

    public boolean isOverdue(){
        return dueDate != null && LocalDate.now().isAfter(dueDate);
    }
}
