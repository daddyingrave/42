package com.github.andreyelagin.backtobackswe.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(List<String> words) {
    var map = new HashMap<String, List<String>>();

    for (String word : words) {
      var key = countLetters(word);
      map.compute(key, (k, v) -> {
        if (v == null) {
          var list = new ArrayList<String>();
          list.add(word);
          return list;
        } else {
          v.add(word);
          return v;
        }
      });
    }

    return new ArrayList<>(map.values());
  }

  private String countLetters(String s) {
    int[] arr = new int[26];

    for (int i = 0; i < s.length(); i++) {
      arr[Character.toLowerCase(s.charAt(i)) - 'a']++;
    }

    var sb = new StringBuilder();
    for (int i : arr) {
      sb.append(i);
    }

    return sb.toString();
  }
}
