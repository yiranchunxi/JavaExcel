package com.spring.excel.Service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITableExcel {

    int existTable(String tableName);

    int dropTable(@Param("tableName")String tableName);

    int createNewTable(@Param("tableName")String tableName);


    List<String> listTables();

}
