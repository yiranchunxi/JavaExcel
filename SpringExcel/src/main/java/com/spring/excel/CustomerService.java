package com.spring.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.spring.excel.Entity.TemplateExcel;
import com.spring.excel.Service.ITemplateExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CustomerService {

	@Autowired
	private ITemplateExcelService templateExcelService;



	List<TemplateExcel> templateExcels=new ArrayList<>();

	public boolean batchImport(String name,File file) {
		
		boolean b=false;
		
		
		//创建处理EXCEL
		ReadExcel readExcel=new ReadExcel();
		templateExcels=readExcel.getExcelInfo(name, file);


		//System.out.println(templateExcels.get(0).toString());

		/*for(int i=0;i<templateExcels.size();i++){
			templateExcelService.insert(templateExcels.get(i));
		}*/

		return b;
		
	}
	
	
}
