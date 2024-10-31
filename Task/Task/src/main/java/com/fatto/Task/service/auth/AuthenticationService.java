package com.fatto.Task.service.auth;

import com.fatto.Task.model.user.User;
import com.fatto.Task.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Service annotation indicates that this class provides authentication-related logic
@Service
public class AuthenticationService implements UserDetailsService {

    // Injecting the IUserRepository to access user data
    @Autowired
    private IUserRepository iUserRepository;

    // Method to load a user by username; required by UserDetailsService interface
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieving user details from the repository
        return iUserRepository.findByUsername(username);
    }
}
