package com.enigmacamp.myjwt.controllers;

import com.enigmacamp.myjwt.models.Course;
import com.enigmacamp.myjwt.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.COURSE_URL)
public class CourseController {

    @Autowired
    CoursesRepository coursesRepository;

    @GetMapping
    public ResponseEntity getAllCourses(){
        List<Course> cours = coursesRepository.findALl();
        return ResponseEntity.ok(cours);
    }

    @GetMapping("/{id}")
    public ResponseEntity getCourseById(@PathVariable String id){
        Course course = coursesRepository.findById(id);
          return ResponseEntity.ok(course);
    }
}
