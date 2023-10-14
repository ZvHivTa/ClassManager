package com.zht.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public class Course {
    private Integer course_id;
    private String course_name;
    private String course_teacher;
    private String course_type;
    private Integer subject_id;
    private Integer course_grade;

    private String course_time;
    private String course_place;
    private Integer course_capacity;

    private Integer course_chosen_number;

    public Course(Integer course_id, String course_name, String course_teacher, String course_type, Integer subject_id, Integer course_grade, String course_time, String course_place, Integer course_capacity, Integer course_chosen_number) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_teacher = course_teacher;
        this.course_type = course_type;
        this.subject_id = subject_id;
        this.course_grade = course_grade;
        this.course_time = course_time;
        this.course_place = course_place;
        this.course_capacity = course_capacity;
        this.course_chosen_number = course_chosen_number;
    }


    public Integer getCourse_chosen_number() {
        return course_chosen_number;
    }

    public void setCourse_chosen_number(Integer course_chosen_number) {
        this.course_chosen_number = course_chosen_number;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course_id=" + course_id +
                ", course_name='" + course_name + '\'' +
                ", course_teacher='" + course_teacher + '\'' +
                ", course_type='" + course_type + '\'' +
                ", subject_id=" + subject_id +
                ", course_grade=" + course_grade +
                ", course_time=" + course_time +
                ", course_place='" + course_place + '\'' +
                ", course_capacity=" + course_capacity +
                '}';
    }

    public Course(Integer course_id, String course_name, String course_teacher, String course_type, Integer subject_id, Integer course_grade, String course_time, String course_place, Integer course_capacity) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_teacher = course_teacher;
        this.course_type = course_type;
        this.subject_id = subject_id;
        this.course_grade = course_grade;
        this.course_time = course_time;
        this.course_place = course_place;
        this.course_capacity = course_capacity;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getCourse_place() {
        return course_place;
    }

    public void setCourse_place(String course_place) {
        this.course_place = course_place;
    }

    public Integer getCourse_capacity() {
        return course_capacity;
    }

    public void setCourse_capacity(Integer course_capacity) {
        this.course_capacity = course_capacity;
    }

    public Course() {
    }

    public Course(Integer course_id, String course_name, String course_teacher, String course_type, Integer subject_id, Integer course_grade) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.course_teacher = course_teacher;
        this.course_type = course_type;
        this.subject_id = subject_id;
        this.course_grade = course_grade;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_teacher() {
        return course_teacher;
    }

    public void setCourse_teacher(String course_teacher) {
        this.course_teacher = course_teacher;
    }

    public String getCourse_type() {
        return course_type;
    }

    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public Integer getCourse_grade() {
        return course_grade;
    }

    public void setCourse_grade(Integer course_grade) {
        this.course_grade = course_grade;
    }
}
