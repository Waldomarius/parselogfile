package com.parselogfile.output;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class OutputExcelFile {

    private File folder = new File("output/");

    public void writeIntoExcel(Map<String, Long> data, String columnName, String file) throws IOException {

        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Report");

        Row rowTitle = sheet.createRow(0);
        Cell reportTitle = rowTitle.createCell(0);
        Cell countTitle = rowTitle.createCell(1);
        reportTitle.setCellValue(columnName);
        countTitle.setCellValue("Count of records:");

        int i = 1;
        for (Map.Entry<String, Long> pair : data.entrySet()) {
            Row row = sheet.createRow(i);
            Cell report = row.createCell(0);
            Cell count = row.createCell(1);
            report.setCellValue(pair.getKey());
            count.setCellValue(pair.getValue());
            i++;
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        if (!folder.exists()) {
            folder.mkdir();
        }

        book.write(new FileOutputStream("output/" + file + ".xls"));
        book.close();
    }
}