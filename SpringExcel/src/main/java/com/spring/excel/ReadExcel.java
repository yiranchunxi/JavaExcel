package com.spring.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ReadExcel {
	//总行数
	private int totalRows=0;
	
	//总条数
	private int totalCells=0;
	
	//错误信息接收器
	private String errorMsg;
	
	//构造方法
	public ReadExcel() {
		
	}
	
	//获取总行数
	public int getTotalRows() {
		return totalRows;
	}
	//获取总列数
	public int getTotalCells() {
		return totalCells;
	}
	
	//获取错误信息
	public String getErrorMsg() {
		return errorMsg;
	}
	
	
	
	   
	/**
	  * 验证EXCEL文件
	  * @param filePath
	  * @return
	 */
	public boolean validateExcel(String filePath) {
		
		if(filePath==null||!(isExcel2003(filePath)||isExcel2007(filePath))) {
			errorMsg = "文件名不是excel格式";  
			return false;
		}
		
		return true;
	}
	
	
	public void getExcelInfo(String fileName,File file) {
		
		 //初始化输入流
		InputStream is=null;
		try {
		    //验证文件名是否合格
	        if(!validateExcel(fileName)){
	             System.out.println(errorMsg);
	        }
	        //根据文件名判断文件是2003版本还是2007版本
	          boolean isExcel2003 = true; 
	          if(ReadExcel.isExcel2007(fileName)){
	              isExcel2003 = false;  
	          }
	          //根据新建的文件实例化输入流
	          is = new FileInputStream(file);
	          //根据excel里面的内容读取客户信息
	          getExcelInfo(is, isExcel2003); 
	          is.close();
			
		}catch (Exception e) {
			// TODO: handle exception
		
		
		}finally {
			if(is !=null)
	          {
	              try{
	                  is.close();
	              }catch(IOException e){
	                  is = null;    
	                  e.printStackTrace();  
	              }
	          }
			
			
		}
		
	}
	
	
	 /**
	   * 根据excel里面的内容读取信息
	   * @param is 输入流
	   * @param isExcel2003 excel是2003还是2007版本
	   * @return
	   * @throws IOException
	   */
	private void getExcelInfo(InputStream is, boolean isExcel2003) {
		// TODO Auto-generated method stub
		
		try {
			 /** 根据版本选择创建Workbook的方式 */
			Workbook wb=null;
			
			//当excel是2003时
			if(isExcel2003) {
				wb=new HSSFWorkbook(is);
			}else {
				//当excel是2007时
				wb=new XSSFWorkbook(is);
			}
			//读取Excel里面客户的信息
			readExcelValue(wb);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();  
		}
		
		
	}
	/**
	   * 读取Excel里面的信息
	   * @param wb
	   * @return
	   */
	private void readExcelValue(Workbook wb) {
	  
	  //得到第一个shell
	  Sheet sheet=wb.getSheetAt(0);
	  //得到Excel的行数
	  this.totalRows=sheet.getPhysicalNumberOfRows();
	  System.out.println("得到Excel的行数"+totalRows);
	  
	  //得到Excel的列数(前提是有行数)
	  if(totalRows>=1 &&sheet.getRow(0)!=null) {
		  this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
	  }
	 
	  //循环Excel行数
	  for(int r=0;r<totalRows;r++) {
		  
		  Row row=sheet.getRow(r);
		  
		  if(row==null)continue;
		  
		   //循环Excel的列
		  for(int c=0;c<this.totalCells;c++) {
			  Cell cell=row.getCell(c);
			  
			  if(cell!=null) {
				 String value =cell.getStringCellValue();
				 
				 System.out.println("value="+value);
			  }
			 
		  }
		  
	  }
		  
	  
	  
	}

	// @描述：是否是2003的excel，返回true是2003 
    public static boolean isExcel2003(String filePath) {
    	
		return filePath.matches("^.+\\.(?i)(xls)$");  
		
    }
    
    //@描述：是否是2007的excel，返回true是2007 
    public static boolean isExcel2007(String filePath) {
    	return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
