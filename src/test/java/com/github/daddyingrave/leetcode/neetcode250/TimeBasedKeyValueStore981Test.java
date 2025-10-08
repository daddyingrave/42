package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore981Test {
  class TimeMap {
    record Pair(String key, String value) {
    }

    Map<String, TreeMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
      var values = map.get(key);
      if (values == null) {
        values = new TreeMap<>();
      }

      values.put(timestamp, value);
      map.put(key, values);
    }

    public String get(String key, int timestamp) {
      var values = map.get(key);
      if (values == null) {
        return "";
      }

      var closestEntry = values.floorEntry(timestamp);
      return closestEntry == null ? "" : closestEntry.getValue();
    }
  }


  @Test
  void test() {
    TimeMap timeMap = new TimeMap();
    timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
    timeMap.get("foo", 1);         // return "bar"
    timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
    timeMap.get("foo", 4);         // return "bar2"
    timeMap.get("foo", 5);         // return "bar2"
  }
}
