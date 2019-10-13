package com.parselogfile;

import com.parselogfile.input.LogFileInput;
import com.parselogfile.report.Report;
import com.parselogfile.report.*;

import java.util.List;
import java.util.Map;

public class LogFiles implements Runnable {

    private LogFileInput data = LogFileInput.getInstance();

    @Override
    public void run() {
        startProcessing();
    }

    void startProcessing() {

        while (true) {
            Map<String, List<List<String>>> dataOneFile = data.getOne();
            if (dataOneFile == null) break;

            /**
             *Выбираем тип отчета:
             *  по году:                    new ReportByYear
             *  по месяцам:                 new ReportByMonth
             *  по дням:                    new ReportByDay
             *  по имени пользователя:      new ReportByUserName
             *  по сообщению:               new ReportByMessage
             */
            Report report = new ReportByDay(dataOneFile);
            report.createReport();
        }
    }
}