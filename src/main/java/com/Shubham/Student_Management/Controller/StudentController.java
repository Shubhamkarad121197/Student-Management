package com.Shubham.Student_Management.Controller;

import com.Shubham.Student_Management.DTO.StudentRequestDTO;
import com.Shubham.Student_Management.Model.Student;
import com.Shubham.Student_Management.Service.StudentService;
import jakarta.validation.Valid;
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
    public Student addStudent(@Valid @RequestBody StudentRequestDTO requestDTO){
      Student student=new Student();
      student.setName(requestDTO.getName());
      student.setEmail(requestDTO.getEmail());

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
    public Student updateStudent(@PathVariable Integer id ,@Valid @RequestBody StudentRequestDTO requestDTO){
        Student student=new Student();
        student.setName(requestDTO.getName());
        student.setEmail(requestDTO.getEmail());

        return studentService.updateStudent(id,student);



    }


    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/students/{studentId}/courses/{courseId}")
    public Student enrollStudentInCourse(
            @PathVariable Integer studentId,
            @PathVariable Integer courseId) {

        return studentService.enrollStudentInCourse(studentId, courseId);
    }
}
