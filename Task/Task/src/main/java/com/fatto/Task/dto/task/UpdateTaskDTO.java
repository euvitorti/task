package com.fatto.Task.dto.task;

import java.math.BigDecimal;
import java.time.LocalDate;

public record UpdateTaskDTO(
        String name,
        BigDecimal cost,
        LocalDate dueDate) { }
