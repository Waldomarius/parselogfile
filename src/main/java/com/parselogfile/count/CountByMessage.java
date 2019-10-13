package com.parselogfile.count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountByMessage implements Count {

    private Map<String, Long> result = new HashMap<>();
    private List<String> listDateMessage = new ArrayList<>();
    private List<String> temp = new ArrayList<>();

    @Override
    public Map<String, Long> result(List<List<String>> assemblyLogFile) {

        listDateMessage.addAll(assemblyLogFile.stream().map(list -> list.get(3)).distinct().collect(Collectors.toList()));
        temp.addAll(assemblyLogFile.stream().map(list -> list.get(3)).collect(Collectors.toList()));

        for (String message : listDateMessage) {
            result.put(message, temp.stream().filter(s -> s.contains(message)).count());
        }
        return result;
    }
}