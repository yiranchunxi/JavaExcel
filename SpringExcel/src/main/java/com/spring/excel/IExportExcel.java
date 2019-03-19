package com.spring.excel;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.OutputStream;
import java.util.Collection;

public interface IExportExcel<T> {
    Workbook exportExcel(String title, String[] headers, Collection<T> dataset, String pattern);
}
