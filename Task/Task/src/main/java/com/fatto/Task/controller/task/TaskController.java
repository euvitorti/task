package com.fatto.Task.controller.task;

import com.fatto.Task.dto.task.TaskDTO;
import com.fatto.Task.model.task.Task;
import com.fatto.Task.repository.task.ITaskRepository;
import com.fatto.Task.service.task.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskRepository iTaskRepository; // Repository for user data

    @Autowired
    private TaskService taskService;

    // Endpoint for user registration
    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid TaskDTO taskDTO, UriComponentsBuilder uriComponentsBuilder){

        // Create a new User object
        var task = new Task(taskDTO);
        // Save the new user in the repository
        iTaskRepository.save(task);

        // Build the URI for the created user
        var uri = uriComponentsBuilder.path("/task/{id}").buildAndExpand(task.getId()).toUri();

        // Return a response indicating that the user has been created, along with the user details
        return ResponseEntity.created(uri).body("OK");
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable String userName) {
        List<Task> tasks = taskService.getTasksByUser(userName);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204 No Content
        }

        return new ResponseEntity<>(tasks, HttpStatus.OK); // 200 OK // Retorna apenas o conteúdo da página
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
