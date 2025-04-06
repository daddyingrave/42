package com.github.daddyingrave.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    var map = new HashMap<String, List<String>>();

    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      map.compute(String.copyValueOf(chars), (s, anagrams) -> {
        if (anagrams == null) {
          anagrams = new ArrayList<>();
        }
        anagrams.add(str);

        return anagrams;
      });
    }

    return new ArrayList<>(map.values());
  }
}
