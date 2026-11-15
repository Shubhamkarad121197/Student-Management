package com.Shubham.Student_Management.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class StudentRequestDTO {
    @NotBlank(message="Student name cannot be empty")
    private String name;

    @NotBlank(message="Email Cannot be empty")
    @Email(message="Please Provide a proper email")
    private String email;

    public StudentRequestDTO(){

    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email=email;
    }
}
