package com.github.daddyingrave.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElementII229 {
  public List<Integer> majorityElement(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    var keysToRemove = new ArrayList<>();
    for (int num : nums) {
      map.compute(num, (k, v) -> v == null ? 1 : v + 1);
      if (map.size() > 2) {

      }
    }



    return map.entrySet()
        .stream()
        .filter((kv) -> kv.getValue() > nums.length / 3)
        .map(Map.Entry::getKey)
        .toList();
  }
}
