package com.Shubham.Student_Management.Controller;

import com.Shubham.Student_Management.Model.Student;
import com.Shubham.Student_Management.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
      return studentService.addStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Integer id ,@RequestBody Student updatedStudent){
       return studentService.updateStudent(id,updatedStudent);

    }


    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }


}
