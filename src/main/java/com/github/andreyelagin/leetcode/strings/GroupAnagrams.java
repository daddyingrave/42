package com.github.andreyelagin.leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    var mappings = new HashMap<String, List<String>>();

    for (String str : strs) {
      var arr = str.toCharArray();
      Arrays.sort(arr);
      
      mappings.compute(new String(arr), (k, v) -> {
        if (v == null) {
          var words = new ArrayList<String>();
          words.add(str);
          return words;
        } else {
          v.add(str);
          return v;
        }
      });
    }
    
    return new ArrayList<>(mappings.values());
  }
}
