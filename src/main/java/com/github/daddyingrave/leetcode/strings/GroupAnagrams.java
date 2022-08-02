package com.github.daddyingrave.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    var mappings = new HashMap<String, List<String>>();

    for (String str : strs) {
      var arr = str.toCharArray();
      char[] symbolsCount = new char[26];
      for (char c : arr) {
        symbolsCount[c - 'a']++;
      }
      
      mappings.compute(new String(symbolsCount), (k, v) -> {
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
