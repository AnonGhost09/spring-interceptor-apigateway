package com.enigmacamp.myjwt.services;

import com.enigmacamp.myjwt.models.Course;
import com.enigmacamp.myjwt.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CoursesRepository coursesRepository;

    public List<Course> listCourse(){
        return coursesRepository.findALl();
    }

    public Course courses(String id){
        return coursesRepository.findById(id);
    }
}
