package com.parselogfile.output;

import java.io.IOException;
import java.util.Map;

public class LogFileOutput {
    private OutputExcelFile excelFile = new OutputExcelFile();

    public void saveReportOnHDD(Map<String, Long> data, String name, String fileName) throws IOException {
            excelFile.writeIntoExcel(data, name, fileName);
    }
}