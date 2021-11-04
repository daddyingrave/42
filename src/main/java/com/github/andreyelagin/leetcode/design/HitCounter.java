package com.github.andreyelagin.leetcode.design;

import java.util.*;

public class HitCounter {
  private final TreeMap<Integer, List<Integer>> indexes = new TreeMap<>();
  private final List<Integer> timestamps = new ArrayList<>();

  public HitCounter() {
  }

  public void hit(int timestamp) {
    if (indexes.containsKey(timestamp)) {
      indexes.get(timestamp).add(timestamps.size());
    } else {
      var list = new ArrayList<Integer>();
      list.add(timestamps.size());
      indexes.put(timestamp, list);
    }
    timestamps.add(timestamp);
  }

  public int getHits(int timestamp) {
    var upper = indexes.floorEntry(timestamp);
    if (upper == null || timestamp - upper.getKey() >= 300) {
      return  0;
    }
    int upperIndex = upper.getValue().get(upper.getValue().size() - 1);
    var lower = indexes.higherEntry(timestamp - 300);
    if (lower == null) {
      return 1;
    }
    int lowerIndex = lower.getValue().get(0);
    
    return upperIndex - lowerIndex + 1;
  }
}
