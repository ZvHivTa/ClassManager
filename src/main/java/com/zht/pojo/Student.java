package com.zht.pojo;

import org.springframework.stereotype.Repository;


public class Student {
    private Integer student_id;
    private String student_name;
    private Integer student_grade;
    private String subject_name;
    private String college_name;

    public Student() {
    }

    public Student(Integer student_id, String student_name, Integer student_grade, String subject_name, String college_name) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.student_grade = student_grade;
        this.subject_name = subject_name;
        this.college_name = college_name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_grade=" + student_grade +
                ", subject_name='" + subject_name + '\'' +
                ", college_name='" + college_name + '\'' +
                '}';
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Integer getStudent_grade() {
        return student_grade;
    }

    public void setStudent_grade(Integer student_grade) {
        this.student_grade = student_grade;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }
}
