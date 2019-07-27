package com.spring.excel.Dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface  CreateTableMapper {

    /**
     *
     * @param tableName
     * @return 1表存在 0表不存在
     */
    int existTable(String tableName);

    int dropTable(@Param("tableName")String tableName);

    int createNewTable(@Param("tableName")String tableName);


    List<String> listTables();
}
