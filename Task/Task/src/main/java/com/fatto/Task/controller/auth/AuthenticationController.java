package com.fatto.Task.controller.auth;

import com.fatto.Task.dto.auth.TokenJwtDTO;
import com.fatto.Task.dto.user.AuthenticationDTO;
import com.fatto.Task.infra.security.TokenJwt;
import com.fatto.Task.model.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This controller class is responsible for handling authentication-related requests.
// It should not contain business logic, only controller methods for handling requests.

@RestController
@RequestMapping("/auth") // Maps all requests starting with /auth to this controller.
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenJwt tokenJwt;

    // Endpoint for user login.
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        try {
            // Create an authentication token using the user's credentials.
            var authToken = new UsernamePasswordAuthenticationToken(authenticationDTO.userName(), authenticationDTO.password());
            // Authenticate the user using the authentication manager.
            var auth = authenticationManager.authenticate(authToken);

            // Generate a JWT token using the authenticated user's information.
            var token = tokenJwt.generateToken((User) auth.getPrincipal());
            // Return the token in the response.
            return ResponseEntity.ok(new TokenJwtDTO(token));
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging purposes.
            // Return a bad request response with the error message if authentication fails.
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
