package com.spring.excel;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadExcel {
		@RequestMapping("/excel")
		public String upload(){        
		     return "upload";
		}

	   @RequestMapping("file/upload")
	   public String upload(HttpSession session,@RequestParam MultipartFile file) throws IllegalStateException,IOException{
		   
		   if(!file.isEmpty()) {
			   String location=session.getServletContext().getRealPath("upload");
			   String url=location+"_"+System.currentTimeMillis()+file.getOriginalFilename();
			   System.out.println(location);
			   System.out.println(url);
			   file.transferTo(new File(url));
		   }
		   return "hello";
	   }
	   
}
