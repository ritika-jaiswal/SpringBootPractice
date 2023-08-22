package com.jwt.authentication.controllers;

            import java.util.List;
            import java.util.Map;
            import java.util.Optional;

            import com.jwt.authentication.entites.Course;
            import com.jwt.authentication.services.CourseService;
            import org.springframework.beans.factory.annotation.Autowired;
            import org.springframework.http.HttpStatus;
            import org.springframework.http.ResponseEntity;
            import org.springframework.security.access.prepost.PostAuthorize;
            import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "", allowedHeaders = "")
@RestController
@RequestMapping("/api/v1/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "WelCome to courese application DCBDU";
    }

    //get all courses
    @GetMapping("/courses")
//    @PostAuthorize("hasAuthority('ROLE_USER')")
    public List<Course> getCourses(@RequestHeader("Authorization") String bearerToken){
        System.out.println(bearerToken +  "dcbdjc jd jc dj cjdj");
        return this.courseService.getCourses();
    }

    //get course by courseId
    @GetMapping("courses/{courseId}")
//    @PostAuthorize("hasAuthority('ROLE_ADMIN')")
    public Optional<Course> getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //	Delete course by courseId
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//	@DeleteMapping("/course/{courseId}")
//	private void deleteCourse(@PathVariable String courseId)
//	{
//		this.courseService.deleteCourse(Long.parseLong(courseId));
//	}

    //Add Course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course,@RequestHeader("Authorization") String bearerToken) {
        return this.courseService.addCourse(course );
    }

    @PutMapping("/courses/{courseId}")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

}
