package com.github.andreyelagin.backtobackswe.strings;

import java.util.Arrays;
import java.util.Comparator;

public class ReplaceWordsWithPrefix {
  public String replaceWordsWithPrefix(String[] prefixes, String sentence) {
    var comparator = Comparator
        .comparing((String str) -> str)
        .thenComparing(String::length);
    Arrays.sort(prefixes, comparator);
    
    var words = sentence.split(" ");
    var res = new StringBuilder();
    
    for (String word : words) {
      boolean matched = false;
      for (String prefix : prefixes) {
        if (prefix.length() > word.length()) {
          continue;
        }
        for (int i = 0; i < prefix.length(); i++) {
          if (prefix.charAt(i) != word.charAt(i)) {
            break;
          }
          if (i == prefix.length() - 1) {
            matched = true;
          }
        }
        if (matched) {
          res.append(prefix).append(" ");
          break;
        }
      }
      if (!matched) {
        res.append(word).append(" ");
      }
    }

    return res.deleteCharAt(res.length() - 1).toString();
  }
}
