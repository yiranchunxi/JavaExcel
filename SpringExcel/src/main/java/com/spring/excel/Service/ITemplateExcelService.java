package com.spring.excel.Service;




import com.spring.excel.Entity.TemplateExcel;

import java.util.List;

public interface ITemplateExcelService {
    int deleteByPrimaryKey(Integer id);

    int insert(TemplateExcel record);

    int insertSelective(TemplateExcel record);

    TemplateExcel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TemplateExcel record);

    int updateByPrimaryKey(TemplateExcel record);

    List<TemplateExcel> selectAll();
}
