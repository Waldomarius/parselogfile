package com.parselogfile.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountByMonth implements Count {

    private Map<String, Long> result = new HashMap<>();
    private List<String> listDateMonth = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    @Override
    public Map<String, Long> result(List<List<String>> assemblyLogFile) {

        listDateMonth.addAll(assemblyLogFile.stream().map(list -> list.get(0).substring(0, 7)).distinct().collect(Collectors.toList()));
        temp.addAll(assemblyLogFile.stream().map(list -> list.get(0).substring(0, 7)).collect(Collectors.toList()));

        for (String month : listDateMonth) {
            result.put(month, temp.stream().filter(s -> s.contains(month)).count());
        }
        return result;
    }
}