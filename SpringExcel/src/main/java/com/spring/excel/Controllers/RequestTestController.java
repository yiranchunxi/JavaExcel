package com.spring.excel.Controllers;


import com.spring.excel.Entity.Student;
import com.spring.excel.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/RequestTest")
public class RequestTestController {

    @Autowired
    private IStudentService service;

    @RequestMapping(method = RequestMethod.GET)
    public String TestString(){
        Student student=new Student();
        student.setUid(UUID.randomUUID().toString().getBytes());
        student.setName("斧王");
        student.setAge(10);
        student.setClassid(1);
        student.setSeclassid(2);

        int a=service.insert(student);
        System.out.println(a);
        return "this is a test string. Time:2017-10-29 20:42:00";
    }
}
