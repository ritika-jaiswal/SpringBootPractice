package com.jwt.authentication.services;


import com.jwt.authentication.entites.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    public List<Course> getCourses();

    public Optional<Course> getCourse(long courseId);

    public Course addCourse(Course course);

    public void deleteCourse(long parseLong);

    public Course updateCourse(Course course);
}
