package com.fatto.Task.service.task;

import com.fatto.Task.model.task.Task;
import com.fatto.Task.repository.task.ITaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository iTaskRepository;

    public List<Task> getTasksByUser(String userName) {
        return iTaskRepository.findByUserName(userName);
    }

    @Transactional
    public void deleteTask(Long id) {
        // Excluir a tarefa
        iTaskRepository.deleteById(id);
    }
}
