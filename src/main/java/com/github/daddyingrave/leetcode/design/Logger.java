package com.github.daddyingrave.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class Logger {
  private final Map<String, Integer> logs = new HashMap<>();

  public Logger() {

  }

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (!logs.containsKey(message)) {
      logs.put(message, timestamp);
      return true;
    }

    int oldTimeStamp = logs.get(message);
    if (timestamp - oldTimeStamp >= 10) {
      logs.put(message, timestamp);
      return true;
    } else {
      return false;
    }
  }
}
