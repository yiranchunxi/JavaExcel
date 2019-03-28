package com.spring.excel.Controllers;

import com.spring.excel.Entity.TemplateExcel;
import com.spring.excel.IExportExcel;
import com.spring.excel.Service.ITemplateExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

@Controller
public class DownloadController {

    @Autowired
    private ITemplateExcelService service;

    @Autowired
    private IExportExcel exportExcel;

    @RequestMapping(value="/notify/download",produces = {"application/vnd.ms-excel;charset=UTF-8"})
    public String download(HttpSession session, HttpServletResponse response){
        String fileName="统计表";
        String [] header=new String[]{"顺号","日期","星期","模板顺号","计划模板","工区编号"};

        try {
            List<TemplateExcel> templateExcels = service.selectAll();
            if(templateExcels!=null){
                System.out.println(templateExcels.size());
            }else{
                System.out.println("error");
            }
            ByteArrayOutputStream os = new ByteArrayOutputStream();


            exportExcel.exportExcel("test",header,templateExcels, "yyyy/MM/dd").write(os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 设置response参数，可以打开下载页面
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
            ServletOutputStream out = response.getOutputStream();
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                bis = new BufferedInputStream(is);
                bos = new BufferedOutputStream(out);
                byte[] buff = new byte[2048];
                int bytesRead;
                // Simple read/write loop.
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            } catch (final IOException e) {
                throw e;
            } finally {
                if (bis != null)
                    bis.close();
                if (bos != null)
                    bos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }



}
