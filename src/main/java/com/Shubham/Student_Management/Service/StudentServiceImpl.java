package com.Shubham.Student_Management.Service;


import com.Shubham.Student_Management.Model.Student;
import com.Shubham.Student_Management.Repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentServiceImpl  implements  StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student=studentRepository.findById(id);

        if(student==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Student not found with id:"+ id
            );
        }
        return student;
    }

    @Override
    public Student updateStudent(Integer id, Student student) {

        Student updateStudent=studentRepository.updateStudent(id,student);
        if(updateStudent==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Student Not found with id:"+id
            );
        }
        return updateStudent;
    }


    @Override
    public void deleteStudent(Integer id) {
        boolean deletedStudent=studentRepository.deleteStudent(id);
        if(!deletedStudent){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Student not found with this Id:"+id
            );
        }

    }
}
