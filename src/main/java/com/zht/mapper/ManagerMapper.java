package com.zht.mapper;

import com.zht.pojo.CourseSelected;
import com.zht.pojo.Manager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {
    Manager selectById(Integer manager_id);

    List<CourseSelected> selectCourseSelectedById(
            @Param("student_id")
            Integer student_id,
            @Param("course_id")
            Integer course_id);


    Integer removeSelectedCourse(
            @Param("student_id")
            Integer student_id,
            @Param("course_id")
            Integer course_id);

}
