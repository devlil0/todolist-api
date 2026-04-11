package com.devlil0.todolist.todolist.database.model;

import com.devlil0.todolist.todolist.enums.Priority;
import com.devlil0.todolist.todolist.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDateTime;

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

    @Future
    private LocalDateTime dueDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private boolean overDue = false;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public boolean isOverdue(){
        return dueDate != null && LocalDateTime.now().isAfter(dueDate);
    }
}
