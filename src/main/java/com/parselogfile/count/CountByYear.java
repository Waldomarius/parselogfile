package com.parselogfile.count;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountByYear implements Count {

    private Map<String, Long> result = new HashMap<>();
    private List<String> listDateYear = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    @Override
    public Map<String, Long> result( List<List<String>> assemblyLogFile) {

        listDateYear.addAll(assemblyLogFile.stream().map(list -> list.get(0).substring(0, 4)).distinct().collect(Collectors.toList()));
        temp.addAll(assemblyLogFile.stream().map(list -> list.get(0).substring(0, 4)).collect(Collectors.toList()));

        for(String year:listDateYear){
            result.put(year,temp.stream().filter(s -> s.contains(year)).count());
        }
        return result;
    }
}