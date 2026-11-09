package com.Shubham.Student_Management.Service;

import com.Shubham.Student_Management.Model.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);
    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    Student updateStudent(Integer id, Student student);

    void deleteStudent(Integer id);


}
