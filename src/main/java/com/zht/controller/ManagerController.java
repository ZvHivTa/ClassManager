package com.zht.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zht.pojo.*;
import com.zht.service.ManagerService;
import com.zht.utils.toInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/management")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("/info")
    @ResponseBody
    public String manager_info_action(HttpSession session,
                                      HttpServletResponse response,
                                      @CookieValue(name="account",required = false) String account){
        User user = null;
        if(account!=null){
            user = new User(Integer.parseInt(account),null);
        }else{
            user = (User) session.getAttribute("MANAGER_SESSION");
        }
        Manager manager = managerService.showManagerInfo(user.getAccount());
        Cookie cookie = new Cookie("manager_name",manager.getManager_name());
        //默认跨域的cookie不能相互访问
        cookie.setPath("/");
        response.addCookie(cookie);
        return JSON.toJSONString(manager);
    }

    @RequestMapping("/course_selected")
    @ResponseBody
    public String search_course_selected_info_action(@RequestBody String responseBody){

        JSONObject responseJson = JSON.parseObject(responseBody, JSONObject.class);
        Integer student_id = null;
        Integer course_id = null;
        String student_id_string =  responseJson.getString("student_id_for_course_search");
        String course_id_string = responseJson.getString("course_id_for_course_search");

        if(!(student_id_string.equals("")||student_id_string.equals("0"))){
            student_id = Integer.parseInt(responseJson.getString("student_id_for_course_search"));
        }
        if(!(course_id_string.equals("")||course_id_string.equals("0"))){
            course_id = Integer.parseInt(responseJson.getString("course_id_for_course_search"));
        }

        List<CourseSelected> list= managerService.showCourseSelected(student_id,course_id);

        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (CourseSelected cs: list) {
            //{"course_id":1006,"course_name":"���˼����ԭ��","course_teacher":"�����"
            String course = JSON.toJSONString(cs.getCourse()).replace("}","");
            //,"student_id":2019000000,"student_name":"����"}
            String student = JSON.toJSONString(cs.getStudent()).replace("{",",");
            sb.append(course);
            sb.append(student);
            sb.append(",");
        }
        if(sb.length()>1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }
    @RequestMapping("/select_course")
    @ResponseBody
    public String select_course_action(@RequestBody String requestBody){
        JSONObject responseJson = JSON.parseObject(requestBody, JSONObject.class);
        Integer student_id = Integer.parseInt(responseJson.getString("student_id"));
        Integer course_id = Integer.parseInt(responseJson.getString("course_id"));
        Integer result = this.managerService.chooseCourseForStudent(student_id,course_id);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/load_subject")
    @ResponseBody
    public String load_subject_action(){

        List<Subject> subjects = this.managerService.selectAllSubjects();
        return JSON.toJSONString(subjects);
    }

    @RequestMapping("/remove_chosen_course")
    @ResponseBody
    public String remove_chosen_course_action(HttpServletRequest request){
        Integer student_id = Integer.parseInt( request.getParameter("student_id"));
        Integer course_id = Integer.parseInt( request.getParameter("course_id"));
        Integer result =  managerService.removeSelectedCourse(student_id,course_id);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/search_course")
    @ResponseBody
    public String search_course_action(@RequestBody String requestBody){
        JSONObject responseJson = JSON.parseObject(requestBody, JSONObject.class);
        String course_id_string = responseJson.getString("course_id");
        String course_name = responseJson.getString("course_name");
        String course_teacher = responseJson.getString("course_teacher");
        Integer course_id = null;
        if(!(course_id_string.equals("")||course_id_string.equals("0"))){
            course_id = Integer.parseInt(course_id_string);
        }
        if(course_name.equals("")){
            course_name = null;
        }
        if(course_teacher.equals("")){
            course_teacher = null;
        }


        List<Course> courses =  managerService.searchCourse(course_id,course_name,course_teacher);

        return JSON.toJSONString(courses);
    }

    @RequestMapping("/remove_course")
    @ResponseBody
    public String remove_course_action(HttpServletRequest request){
        Integer course_id = Integer.parseInt( request.getParameter("course_id"));
        Integer result =  managerService.removeCourse(course_id);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/update_course")
    @ResponseBody
    public String update_course_action(@RequestBody String requestBody){
        //{"subject_id":"",
        // "course_id":6000,
        // "course_teacher":"��ǿ",
        // "course_type":"2",
        // "course_name":"ϰ��ƽ�й���ɫ�������˼����",
        // "subject_name":"����",
        // "index":0,
        // "course_capacity":""}

        JSONObject responseJson = JSON.parseObject(requestBody, JSONObject.class);
        Integer course_id=null;
        Integer course_grade=null;
        Integer course_capacity=null;
        Integer subject_id = null;
        String course_id_string = responseJson.getString("course_id");
        String course_name = responseJson.getString("course_name");
        String course_teacher = responseJson.getString("course_teacher");
        String course_type_string = responseJson.getString("course_type");
        String course_capacity_string = responseJson.getString("course_capacity");
        String subject_id_string = responseJson.getString("subject_id");
        String course_grade_string = responseJson.getString("course_grade");
        String course_place = responseJson.getString("course_place");
        String course_time = responseJson.getString("course_time");

        course_id = toInteger.parseInteger(course_id_string);
        course_grade = toInteger.parseInteger(course_grade_string);
        course_capacity = toInteger.parseInteger(course_capacity_string);
        subject_id = toInteger.parseInteger(subject_id_string);

        Course course = new Course(course_id,
                course_name,
                course_teacher,
                course_type_string,
                subject_id,
                course_grade,
                course_time,
                course_place,
                course_capacity
        );

        Integer result = managerService.updateCourse(course);

        return JSON.toJSONString(result);
    }

    @RequestMapping("/insert_course")
    @ResponseBody
    public String insert_course_action(@RequestBody String requestBody){
        System.out.println(requestBody);
       /*{"course_id":"1201",
       "course_name":"�ߵ���ѧ",
       "course_teacher":"����",
       "course_type":"1",
       "course_time":"��������6-7��",
       "course_place":"401",
       "course_capacity":"90",
       "subject_id":"",
       "course_grade":"1",
       "subject_name":"ͨ�Ź���"}
        */

        JSONObject responseJson = JSON.parseObject(requestBody, JSONObject.class);
        Integer course_id=null;
        Integer course_grade=null;
        Integer course_capacity=null;
        Integer subject_id = null;
        String course_id_string = responseJson.getString("course_id");
        String course_name = responseJson.getString("course_name");
        String course_teacher = responseJson.getString("course_teacher");
        String course_type_string = responseJson.getString("course_type");
        String course_capacity_string = responseJson.getString("course_capacity");
        String subject_id_string = responseJson.getString("subject_id");
        String course_grade_string = responseJson.getString("course_grade");
        String course_place = responseJson.getString("course_place");
        String course_time = responseJson.getString("course_time");

        course_id = toInteger.parseInteger(course_id_string);
        course_grade = toInteger.parseInteger(course_grade_string);
        course_capacity = toInteger.parseInteger(course_capacity_string);
        subject_id = toInteger.parseInteger(subject_id_string);

        Course course = new Course(course_id,
                course_name,
                course_teacher,
                course_type_string,
                subject_id,
                course_grade,
                course_time,
                course_place,
                course_capacity
        );

        Integer result = managerService.insertCourse(course);

        return JSON.toJSONString(result);

    }


}
