package com.devlil0.todolist.todolist.database.repository;

import com.devlil0.todolist.todolist.database.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<TaskEntity, Long> {
}
