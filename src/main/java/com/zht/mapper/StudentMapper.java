package com.zht.mapper;

import com.zht.pojo.Course;
import com.zht.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    //查找特定学生的基本信息
    Student selectById(Integer id);

    Integer insertIntoCourseSelected(
            @Param("student_id")
            Integer student_id,
            @Param("course_id")
            Integer course_id);

    Integer deleteFromCourseSelected(@Param("student_id")
                                     Integer student_id,
                                     @Param("course_id")
                                     Integer course_id);



}
