package com.invotrack.springvalidationnotes.model;

import jakarta.validation.constraints.*;

public class User {

    @Max(10)
    private int id;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "Name must be upto 255 characters")
    private String name;

    @NotBlank(message = "email is required")
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank(message = "password is required")
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.{8,}).*$",
            message = "Password must be at least 8 characters long and include a mix of uppercase, lowercase, numbers, and special characters"
    )
    private String password;

    public User() {
    }

    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
