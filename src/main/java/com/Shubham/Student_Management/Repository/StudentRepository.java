package com.Shubham.Student_Management.Repository;

import com.Shubham.Student_Management.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {

}