package com.fatto.Task.repository.task;

import com.fatto.Task.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserName(String userName);
}
