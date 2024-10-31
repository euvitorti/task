package com.fatto.Task.controller.task;

import com.fatto.Task.dto.task.TaskDTO;
import com.fatto.Task.model.task.Task;
import com.fatto.Task.repository.task.ITaskRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskRepository iTaskRepository; // Repository for user data

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
}
