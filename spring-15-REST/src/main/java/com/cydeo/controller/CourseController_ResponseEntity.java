package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v2")
public class CourseController_ResponseEntity {

    private final CourseService courseService;

    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){ //coming with Spring framework and purpose is to manipulate status code;
        return ResponseEntity
                .status(HttpStatus.ACCEPTED) //ready methods
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body(courseService.getCourses());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable("id") long courseId){
        return ResponseEntity.ok(courseService.getCourseById(courseId)); //ok is ready method, takes dto object
    }


    @GetMapping("category/{name}")
    public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable("name") String category){
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course){
        return ResponseEntity
                .status(HttpStatus.CREATED) //status code 201
                .header("Operation","Create")
                .body(courseService.createCourse(course));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long courseId){ //we can put void when deleting, we can't skip this, it is asking something to provide.
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();

        //if we use instead of void courseDTO still works.
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCourse(@PathVariable("id") Long courseId,@RequestBody CourseDTO course){ //as it is not returning anything we use void in generic, because we can't skip
        courseService.updateCourse(courseId,course);
        return ResponseEntity.noContent().build();
    }

}
