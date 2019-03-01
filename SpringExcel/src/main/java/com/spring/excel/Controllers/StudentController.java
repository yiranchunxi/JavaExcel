package com.spring.excel.Controllers;



import com.spring.excel.Entity.Student;
import com.spring.excel.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/Student")
public class StudentController {
    @Autowired
    private IStudentService service;

    @RequestMapping(method = RequestMethod.GET)
    public String Get() {
        List<Student> students = service.selectByCondition(new Student());
        //String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        //return jsonResult;
        return "hehe";
    }
}
