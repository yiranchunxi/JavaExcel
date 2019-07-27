package com.spring.excel.Controllers;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import com.spring.excel.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadExcel {
	
	    @Autowired
	    private CustomerService mCustomerService;
	
		@RequestMapping("/excel")
		public String upload(){        
		     return "upload";
		}

	   @RequestMapping("file/upload")
	   public String upload(HttpSession session,@RequestParam MultipartFile file) throws IllegalStateException,IOException{
		   File diskFile = null;
		   if(!file.isEmpty()) {
			   String location=session.getServletContext().getRealPath("upload");
			   String url=location+"_"+System.currentTimeMillis()+file.getOriginalFilename();
			   System.out.println(location);
			   System.out.println(url);
			   diskFile=new File(url);
			   file.transferTo(diskFile);
			   System.out.println(11111);
			  
			   System.out.println(2222);
			   //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
			   String name=file.getOriginalFilename();
			   long size=file.getSize();
			   System.out.println(name+size);
			   if(name==null||("").equals(name)&&size==0) return null;
			   
			   //批量导入。参数：文件名，文件。
			   mCustomerService.batchImport(name, diskFile);
		   }
		   
		   
		   
		   
		   return "hehe";
	   }
	   
}
