package com.spring.excel.Controllers;


import com.spring.excel.Dao.CreateTableMapper;
import com.spring.excel.Entity.Student;
import com.spring.excel.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/RequestTest")
public class RequestTestController {

    @Autowired
    private IStudentService service;

    @Autowired
    private CreateTableMapper createTableMapper;

    @RequestMapping(method = RequestMethod.GET)
    public String TestString(){

        List<String> list=createTableMapper.listTables();

        System.out.println(list.size());

        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return "this is a test string. Time:"+format.format(date);
    }
}
