package com.spring.excel.Controllers;

import com.spring.excel.Entity.TemplateExcel;
import com.spring.excel.Service.ITemplateExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mvc")
public class HelloController {
	


	 @RequestMapping("/hello")
	 public String hello(){



	        return "hello";
	 }




}
