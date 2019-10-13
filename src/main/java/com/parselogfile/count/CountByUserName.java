package com.parselogfile.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountByUserName implements Count {

    private Map<String, Long> result = new HashMap<>();
    private List<String> listUserName = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    @Override
    public Map<String, Long> result(List<List<String>> assemblyLogFile) {

        listUserName.addAll(assemblyLogFile.stream().map(list -> list.get(2)).distinct().collect(Collectors.toList()));
        temp.addAll(assemblyLogFile.stream().map(list -> list.get(2)).collect(Collectors.toList()));

        for (String userName : listUserName) {
            result.put(userName, temp.stream().filter(s -> s.matches(userName)).count());
        }
        return result;
    }
}