package com.zht.service;

import com.zht.pojo.Course;
import com.zht.pojo.CourseSelected;
import com.zht.pojo.Manager;
import com.zht.pojo.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerService {
    Manager showManagerInfo(Integer manager_id);

    List<CourseSelected> showCourseSelected(Integer student_id,Integer course_id);

    Integer removeSelectedCourse(Integer student_id,Integer course_id);

    Integer chooseCourseForStudent(Integer student_id,Integer course_id);

    List<Course> searchCourse(Integer course_id, String course_name, String course_teacher);
    List<Subject> selectAllSubjects();

    Integer removeCourse(Integer course_id);
    Integer updateCourse(Course course);

    Integer insertCourse(Course course);






}
