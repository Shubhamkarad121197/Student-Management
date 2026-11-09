package com.Shubham.Student_Management.Repository;

import com.Shubham.Student_Management.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentRepository {
    List<Student> students= new ArrayList<>();

    public Student save(Student student){
        students.add(student);
        return student;
    }
    public List<Student> findAll(){
        return students;
    }

    public Student findById(Integer id){
        return students.stream()
                .filter((s)->s.getId().equals(id))
                .findFirst()
                .orElse(
                        null
                );

    }
    public Student updateStudent(Integer id,Student updatedStudent){
       for(Student student : students){
           if(Objects.equals(student.getId(),id)){
               student.setName(updatedStudent.getName());
               student.setEmail(updatedStudent.getEmail());
               return student;
           }

       }
       return null;
    }
    public boolean deleteStudent(Integer id){
        return students.removeIf(
                student->student.getId().equals(id)
        );
    }
}
