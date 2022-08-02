package com.github.daddyingrave.leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
  private final Map<String, TreeMap<Integer, String>> storage = new HashMap<>();
  
  public TimeMap() {
  }

  public void set(String key, String value, int timestamp) {
    var node = storage.get(key);
    if (node == null) {
      var newNode = new TreeMap<Integer, String>();
      newNode.put(timestamp, value);
      storage.put(key, newNode);
    } else {
      node.put(timestamp, value);
    }
  }

  public String get(String key, int timestamp) {
    var node = storage.get(key);
    if (node != null) {
      var value = node.floorEntry(timestamp);
      if (value != null) {
        return value.getValue();
      }
    }
    return "";
  }
}
