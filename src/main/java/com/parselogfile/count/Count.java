package com.parselogfile.count;

import java.util.List;
import java.util.Map;

public interface Count {
    Map<String, Long> result(List<List<String>> assemblyLogFile);
}