package com.parselogfile.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class LogFileInput {

    private Map<String, List<List<String>>> allData = new HashMap<>();
    private static LogFileInput instance;

    private LogFileInput() {
        getAllDataFromDisc();
    }

    public static LogFileInput getInstance() {
        if (instance == null) {
            instance = new LogFileInput();
        }
        return instance;
    }

    public synchronized Map<String, List<List<String>>> getOne() {
        List<String> temp = allData.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
        Map<String, List<List<String>>> dataOneFile = new HashMap<>();

        if (temp.size() > 0) {
            dataOneFile.put(temp.get(temp.size() - 1), allData.get(temp.get(temp.size() - 1)));
            allData.remove(temp.get(temp.size() - 1));
            return dataOneFile;
        } else {
            return null;
        }
    }

    private void getAllDataFromDisc() {
        File folder = new File("input/");
        try {
            List<String> files = Arrays.asList(folder.list((folder1, name) -> name.endsWith(".txt")));

            for (String fileName : files) {
                List<List<String>> assemblyLogFile = new ArrayList<>();

                File file = new File("input/" + fileName);
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    while (true) {
                        String line = br.readLine();
                        if (line == null) break;
                        assemblyLogFile.add(Arrays.asList(line.split("[ \\t\\v\\r\\n\\f]")));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                allData.put(fileName.replace(".txt", ""), assemblyLogFile);
            }
        } catch (NullPointerException e) {
            System.out.println("No input files");
        }
    }
}