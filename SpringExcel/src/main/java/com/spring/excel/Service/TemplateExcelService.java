package com.spring.excel.Service;

import com.spring.excel.Dao.TemplateExcelMapper;
import com.spring.excel.Entity.TemplateExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateExcelService implements ITemplateExcelService {

    @Autowired
    private TemplateExcelMapper templateExcelMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return templateExcelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(com.spring.excel.Entity.TemplateExcel record) {
        return templateExcelMapper.insert(record);
    }

    @Override
    public int insertSelective(com.spring.excel.Entity.TemplateExcel record) {
        return templateExcelMapper.insertSelective(record);
    }

    @Override
    public com.spring.excel.Entity.TemplateExcel selectByPrimaryKey(Integer id) {
        return templateExcelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(com.spring.excel.Entity.TemplateExcel record) {
        return templateExcelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(com.spring.excel.Entity.TemplateExcel record) {
        return templateExcelMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TemplateExcel> selectAll() {
        return templateExcelMapper.selectAll();
    }
}
