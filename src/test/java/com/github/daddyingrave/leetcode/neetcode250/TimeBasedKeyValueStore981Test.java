package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TimeBasedKeyValueStore981Test {
  class TimeMap {
    record Pair(Integer ts, String value) {
    }

    Map<String, List<Pair>> map = new HashMap<>();

    public TimeMap() {
    }

    public void set(String key, String value, int timestamp) {
      var values = map.get(key);
      if (values == null) {
        values = new ArrayList<>();
      }

      values.add(new Pair(timestamp, value));
      map.put(key, values);
    }

    public String get(String key, int timestamp) {
      var values = map.get(key);
      if (values == null) {
        return "";
      }

      int left = 0;
      int right = values.size() - 1;
      int maxTs = -1;
      String maxVal = "";

      while (left <= right) {
        int mid = left + (right - left) / 2;
        int curTs = values.get(mid).ts;
        if (curTs == timestamp) {
          return values.get(mid).value;
        } else if (curTs < timestamp) {
          if (curTs > maxTs) {
            maxTs = curTs;
            maxVal = values.get(mid).value;
          }
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return maxVal;
    }
  }


  @Test
  void test() {
    TimeMap timeMap = new TimeMap();
    timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
    assertEquals("bar", timeMap.get("foo", 1));         // return "bar"
    assertEquals("bar", timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
    assertEquals("bar2", timeMap.get("foo", 4));
    assertEquals("bar2", timeMap.get("foo", 5));
  }
}
