package com.invotrack.springvalidationnotes.controller;

import com.invotrack.springvalidationnotes.model.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/register-user")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User registered successfully!");
    }

}
