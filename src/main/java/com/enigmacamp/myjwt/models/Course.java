package com.enigmacamp.myjwt.models;

public class Course {
    private String courseId;
    private String courseName;
    private String courseApaya;

    public Course(String courseId, String courseName, String courseApaya) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseApaya = courseApaya;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseApaya() {
        return courseApaya;
    }

    public void setCourseApaya(String courseApaya) {
        this.courseApaya = courseApaya;
    }
}
