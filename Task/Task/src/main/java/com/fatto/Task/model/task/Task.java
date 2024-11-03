package com.fatto.Task.model.task;

import com.fatto.Task.dto.task.TaskDTO;
import com.fatto.Task.dto.task.UpdateTaskDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Task Identifier (Primary Key)

    @Column(nullable = false)
    private String name; // Task Name

    @Column(nullable = false)
    private BigDecimal cost; // Cost (R$)

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate; // Due Date

    @Column(nullable = false)
    private String userName; // Relation with User

    // Constructors
    public Task() {}

    public Task(TaskDTO taskDTO) {
        this.name = taskDTO.name();
        this.cost = taskDTO.cost();
        this.dueDate = taskDTO.dueDate();
        this.userName = taskDTO.userName();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }

    public void updateTask(UpdateTaskDTO updateTaskDTO) {
        this.name = updateTaskDTO.name();
        this.cost = updateTaskDTO.cost();
        this.dueDate = updateTaskDTO.dueDate();
    }
}
