package com.jwt.authentication.services;

import com.jwt.authentication.dao.CourseDao;
import com.jwt.authentication.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

//	List<Course> list;

    public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(111, "Core Java Course", "This course contains basics of core java course."));
//		list.add(new Course(112, "Advance Java Course", "This course contains basics of advance java course."));
//		list.add(new Course(113, "Spring Boot Course", "This course contains spring boot course."));
//		list.add(new Course(114, "C# Course", "This course contains basics of c# course."));

    }

    @Override
    public List<Course> getCourses() {
//		return list;
        return courseDao.findAll();
    }

    @Override
    public Optional<Course> getCourse(long courseId) {

//		Course c=null;
//
//		for(Course course:list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
        return courseDao.findById(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//		list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
//		list= this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//		Optional<Course> entity = courseDao.findById(parseLong);
        courseDao.deleteById(parseLong);
    }

    @Override
    public Course updateCourse(Course course) {
//		list.forEach(e -> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
        courseDao.save(course);
        return course;
    }

}
