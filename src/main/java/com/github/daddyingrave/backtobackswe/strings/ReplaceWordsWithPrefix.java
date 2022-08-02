package com.github.daddyingrave.backtobackswe.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class ReplaceWordsWithPrefix {
  public String replaceWordsWithPrefix(String[] prefixes, String sentence) {
    var prefs = new HashSet<>(Arrays.asList(prefixes));
    var words = sentence.split(" ");

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int j = 0; j < word.length(); j++) {
        var subWord = word.substring(0, j);
        if (prefs.contains(subWord)) {
          words[i] = subWord;
          break;
        }
      }
    }

    return String.join(" ", words);
  }

  public String replaceWordsWithPrefixMy(String[] prefixes, String sentence) {
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
