package com.spring.excel;

import com.spring.excel.Entity.TemplateExcel;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
@Service
public class ExportExeclImpl implements IExportExcel<TemplateExcel> {

    @Override
    public Workbook exportExcel(String title, String[] headers, Collection<TemplateExcel> dataset, String pattern) {


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
        HSSFRow row =sheet.createRow(0);
        HSSFCell cell=row.createCell(0);
        cell.setCellStyle(style);
        HSSFRichTextString text=new HSSFRichTextString("检查车间计划数据中心");
        cell.setCellValue(text);
        // 产生表格标题行
        row =sheet.createRow(1);
        for(int i=0;i<headers.length;i++){
            cell=row.createCell(i);
            cell.setCellStyle(style);
            text=new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<TemplateExcel> it=dataset.iterator();
        int index=1;
        while (it.hasNext()){


            index++;
            row=sheet.createRow(index);
            TemplateExcel obj=it.next();

            //顺号
            cell=row.createCell(0);
            cell.setCellFormula(obj.getSid());
            //日期
            cell=row.createCell(1);
            Date date = obj.getSdate();
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            String textValue = sdf.format(date);
            cell.setCellValue(textValue);

            //星期
            cell=row.createCell(2);
            cell.setCellValue(obj.getToday());

            //模板顺号
            cell=row.createCell(3);
            cell.setCellValue(obj.getTemplateId());

            //计划模板
            cell=row.createCell(4);
            cell.setCellValue(obj.getTemplateInfo());

            //工区编号
            cell=row.createCell(5);
            cell.setCellValue(obj.getWorkNumber());


            /*HSSFRichTextString richTextString=new HSSFRichTextString(textValue);
            richTextString.applyFont(font);
            cell.setCellValue(richTextString);
            */
        }

        return  workbook;

    }
}
