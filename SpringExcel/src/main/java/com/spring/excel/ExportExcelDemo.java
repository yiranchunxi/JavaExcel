package com.spring.excel;

import org.apache.poi.hssf.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExportExcelDemo<T>{

    public void exportExcel(String title, Collection<T> dataset, OutputStream out){
        
        exportExcel(title,null,dataset,out,"yyyy-MM-DD");
    }
    
    public void  exportExcel(String title,String[] headers,Collection<T> dataset,OutputStream out){
        
        exportExcel(title,headers,dataset,out,"yyyy-MM-DD");
    }

    @SuppressWarnings("unchecked")
    private void exportExcel(String title, String[] headers, Collection<T> dataset, OutputStream out, String pattern) {

        // 声明一个工作薄
        HSSFWorkbook workbook=new HSSFWorkbook();

        // 生成一个表格
        HSSFSheet sheet=workbook.createSheet(title);

        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short)15);

        // 生成一个样式
        HSSFCellStyle style=workbook.createCellStyle();

        // 生成一个字体
        HSSFFont font=workbook.createFont();
        font.setFontHeightInPoints((short) 12);

        // 把字体应用到当前的样式
        style.setFont(font);

        // 产生表格标题行
        HSSFRow row =sheet.createRow(0);
        for(int i=0;i<headers.length;i++){
            HSSFCell cell=row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text=new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it=dataset.iterator();
        int index=0;
        while (it.hasNext()){


            index++;
            row=sheet.createRow(index);
            T t=it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields=t.getClass().getDeclaredFields();
            for(int i=0;i<fields.length;i++){
                HSSFCell cell=row.createCell(i);
                cell.setCellStyle(style);
                Field field=fields[i];
                String fieldName=field.getName();
                String getMethodName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);


                try {
                    Class tCls=t.getClass();
                    Method getMethod=tCls.getMethod(getMethodName,new Class[]{});

                    Object value=getMethod.invoke(t,new Object[]{});
                    // 判断值的类型后进行强制类型转换
                    String textValue=null;
                    if(value instanceof Integer){
                        int intValue= (int) value;
                        cell.setCellValue(intValue);
                    }else if(value instanceof Long){
                        long longValue = (Long) value;
                        cell.setCellValue(longValue);
                    }else if(value instanceof  Boolean){
                        boolean bValue = (Boolean) value;
                        textValue = "1";
                        if (!bValue) {
                            textValue = "0";
                        }
                    }else if(value instanceof Date){
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    }else{
                        // 其它数据类型都当作字符串简单处理
                        if(value==null){
                            textValue="";
                        }else {
                            textValue=value.toString();
                        }
                    }

                    if(textValue!=null){

                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if(matcher.matches()){
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        }else{

                            HSSFRichTextString richTextString=new HSSFRichTextString(textValue);
                            richTextString.applyFont(font);
                            cell.setCellValue(richTextString);

                        }
                    }

                 } catch (IllegalAccessException e) {
                        e.printStackTrace();
                } catch (InvocationTargetException e) {
                        e.printStackTrace();
                }
                catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }finally {

                }


            }

        }

        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
