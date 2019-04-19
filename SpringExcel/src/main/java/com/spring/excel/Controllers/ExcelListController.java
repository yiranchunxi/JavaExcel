package com.spring.excel.Controllers;


import com.spring.excel.Entity.TemplateExcel;
import com.spring.excel.Service.ITableExcel;
import com.spring.excel.Service.ITemplateExcelService;
import com.spring.excel.Service.TableExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelListController {

    @Autowired
    private ITableExcel tableExcelService;

    @Autowired
    private ITemplateExcelService service;

    private   String [] header=new String[]{"id","顺号","日期","星期","模板顺号","计划模板","工区编号"};

    @RequestMapping("/list")
    public String excelList(Model model){

        model.addAttribute("excelList",tableExcelService.listTables());
        return "excelList";
    }

    @RequestMapping("/viewDetail")
    public String excelView(Model model){
        model.addAttribute("tableHeader",header);
        model.addAttribute("templateExcel",service.selectAll());
        return "viewDetail";
    }
}
