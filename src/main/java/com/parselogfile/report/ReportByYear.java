package com.parselogfile.report;

import com.parselogfile.count.CountByYear;
import com.parselogfile.output.LogFileOutput;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportByYear extends Report {

    private LogFileOutput output = new LogFileOutput();
    private List<List<String>> data;
    private String name;
    private String fileName;

    public ReportByYear(Map<String, List<List<String>>> data) {

        count = new CountByYear();

        for (Map.Entry<String, List<List<String>>> pair : data.entrySet()) {
            this.data = pair.getValue();
            this.fileName = pair.getKey();
        }
        name = "Report by year";
    }

    @Override
    public void createReport() {
        try {
            output.saveReportOnHDD(executeCount(data), name, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}