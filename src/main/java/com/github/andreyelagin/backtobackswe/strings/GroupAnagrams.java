package com.github.andreyelagin.backtobackswe.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(List<String> words) {
    var map = new HashMap<List<Integer>, List<String>>();

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

  private List<Integer> countLetters(String s) {
    var list = new ArrayList<Integer>(26);
    for (int i = 0; i < 26; i++) {
      list.add(0);
    }

    for (int i = 0; i < s.length(); i++) {
      int index = Character.toLowerCase(s.charAt(i)) - 'a';
      list.set(index, list.get(index) + 1);
    }

    return list;
  }
}
