package com.Shubham.Student_Management.Repository;

import com.Shubham.Student_Management.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}

