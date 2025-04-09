package com.github.daddyingrave.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements347 {
  public int[] topKFrequent(int[] nums, int k) {
    var map = new HashMap<Integer, Integer>();
    for (int num : nums) {
      map.compute(num, (key, v) -> v == null ? 1 : v + 1);
    }

    List<Integer>[] counters = new List[nums.length + 1];
    map.forEach((key, v) -> {
      var storage = counters[v];
      if (storage == null) {
        storage = new ArrayList<>();
      }
      storage.add(key);
      counters[v] = storage;
    });

    int[] result = new int[k];
    for (int i = counters.length - 1; i >= 0; i--) {
      List<Integer> integers = counters[i];
      if (integers != null) {
        for (int j = 0; j < integers.size() && k > 0; j++, k--) {
          result[k - 1] = integers.get(j);
        }
      }
    }

    return result;
  }
}
