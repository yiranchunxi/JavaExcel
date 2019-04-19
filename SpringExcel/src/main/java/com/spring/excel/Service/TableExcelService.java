package com.spring.excel.Service;

import com.spring.excel.Dao.CreateTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableExcelService implements ITableExcel{

    @Autowired
    private CreateTableMapper createTableMapper;

    @Override
    public int existTable(String tableName) {
        return createTableMapper.existTable(tableName);
    }

    @Override
    public int dropTable(String tableName) {
        return createTableMapper.dropTable(tableName);
    }

    @Override
    public int createNewTable(String tableName) {
        return createTableMapper.createNewTable(tableName);
    }

    @Override
    public List<String> listTables() {
        return createTableMapper.listTables();
    }
}
