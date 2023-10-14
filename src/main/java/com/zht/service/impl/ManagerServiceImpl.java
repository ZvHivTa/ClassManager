package com.zht.service.impl;

import com.zht.mapper.CourseMapper;
import com.zht.mapper.ManagerMapper;
import com.zht.mapper.StudentMapper;
import com.zht.mapper.SubjectMapper;
import com.zht.pojo.Course;
import com.zht.pojo.CourseSelected;
import com.zht.pojo.Manager;
import com.zht.pojo.Subject;
import com.zht.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    SubjectMapper subjectMapper;

    @Autowired
    StudentMapper studentMapper;
    @Override
    public Manager showManagerInfo(Integer manager_id) {
        return managerMapper.selectById(manager_id);
    }

    @Override
    public List<CourseSelected> showCourseSelected(Integer student_id,Integer course_id) {
        return managerMapper.selectCourseSelectedById(student_id,course_id);
    }

    @Override
    public Integer removeSelectedCourse(Integer student_id, Integer course_id) {
        return managerMapper.removeSelectedCourse(student_id,course_id);
    }

    @Override
    public Integer chooseCourseForStudent(Integer student_id, Integer course_id) {
        return studentMapper.insertIntoCourseSelected(student_id,course_id);
    }

    @Override
    public List<Course> searchCourse(Integer course_id, String course_name, String course_teacher) {
        return courseMapper.selectForManager(course_id,course_name,course_teacher);
    }

    @Override
    public List<Subject> selectAllSubjects() {
        return subjectMapper.selectAllSubjects();
    }

    @Override
    public Integer removeCourse(Integer course_id) {
        return courseMapper.removeCourse(course_id);
    }

    @Override
    public Integer updateCourse(Course course) {
        Integer result = 0;
        Integer num = null;
        num = courseMapper.selectFromCourseArrangment(course.getCourse_id());
        if(num==null){
            courseMapper.updateCourse(course);
            result = courseMapper.insertIntoCourseArrangment(course);
        }else{
            courseMapper.updateCourse(course);
            result = courseMapper.updateCourseArrangment(course);
        }

        return result;
    }

    @Override
    public Integer insertCourse(Course course) {
        Integer num = null;
        List<Course> courses = courseMapper.selectForManager(course.getCourse_id(),null,null);
        num = courses.size();
        if(num==0){
            courseMapper.insertCourse(course);
            num = courseMapper.insertIntoCourseArrangment(course);
        }
        return num;
    }
}
