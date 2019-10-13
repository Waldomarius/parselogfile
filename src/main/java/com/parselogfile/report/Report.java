package com.parselogfile.report;


import com.parselogfile.count.Count;

import java.util.List;
import java.util.Map;

public abstract class Report {

    protected Count count;

    protected Map<String, Long> executeCount(List<List<String>> data){
        return count.result(data);
    }

    public abstract void createReport();
}
