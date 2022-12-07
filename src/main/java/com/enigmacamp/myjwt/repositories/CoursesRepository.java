package com.enigmacamp.myjwt.repositories;

import com.enigmacamp.myjwt.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CoursesRepository {
    List<Course> data = new ArrayList<>(Arrays.asList(
            new Course("1","INGGRIS 1","APA YA"),
            new Course("2","INGGRIS 2","APA YA"),
            new Course("3","INGGRIS 3","APA YA"),
            new Course("4","INGGRIS 4","APA YA"),
            new Course("5","INGGRIS 5","APA YA")));

    public List<Course> findALl(){
        return data;
    }

    public Course findById(String id){
        for (Course course :
             data) {
            if(course.getCourseId().equals(id)){
                return course;
            }
        }
        return null;
    }
}
