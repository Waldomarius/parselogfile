package com.parselogfile.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountByDay implements Count {

    private Map<String, Long> result = new HashMap<>();
    private List<String> listDateDay = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    @Override
    public Map<String, Long> result(List<List<String>> assemblyLogFile) {

        listDateDay.addAll(assemblyLogFile.stream().map(list -> list.get(0).substring(0, 10)).distinct().collect(Collectors.toList()));
        temp.addAll(assemblyLogFile.stream().map(list -> list.get(0).substring(0, 10)).collect(Collectors.toList()));

        for (String day : listDateDay) {
            result.put(day, temp.stream().filter(s -> s.contains(day)).count());
        }
        return result;
    }
}