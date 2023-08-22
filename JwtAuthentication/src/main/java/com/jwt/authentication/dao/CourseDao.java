package com.jwt.authentication.dao;


import com.jwt.authentication.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Long> {

}
