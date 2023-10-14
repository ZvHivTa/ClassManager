package com.zht.mapper;

import com.zht.pojo.Course;
import com.zht.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> selectForSuggestion(Student student);

    List<Course> selectForOptional(Integer course_type);

    List<Course> selectForChosen(Integer student_id);

    List<Course> selectForManager(
            @Param("course_id")
            Integer course_id,
            @Param("course_name")
            String course_name,
            @Param("course_teacher")
            String course_teacher);

    Integer removeCourse(@Param("course_id") Integer course_id);

    Integer updateCourse(Course course);

    Integer insertCourse(Course course);


    Integer selectFromCourseArrangment(Integer course_id);

    Integer insertIntoCourseArrangment(Course course);

    Integer updateCourseArrangment(Course course);



}
