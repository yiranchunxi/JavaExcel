package com.spring.excel;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CustomerService {

	
	public boolean batchImport(String name,File file) {
		
		boolean b=false;
		
		
		//创建处理EXCEL
		ReadExcel readExcel=new ReadExcel();
		readExcel.getExcelInfo(name, file);
		
		
		
		return b;
		
	}
	
	
}
