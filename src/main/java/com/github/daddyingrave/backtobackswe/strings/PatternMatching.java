package com.github.daddyingrave.backtobackswe.strings;

import java.util.*;

public class PatternMatching {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> matchedWords = new ArrayList<>();
    String patternEncoded = encode(pattern);

    for (String word : words) {
      if (word.length() == pattern.length() && patternEncoded.equals(encode(word))) {
        matchedWords.add(word);
      }
    }

    return matchedWords;
  }

  private String encode(String word) {
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> codes = new HashMap<>();

    int i = 0;

    for (int j = 0; j < word.length(); j++) {
      char curChar = word.charAt(j);
      Integer code = codes.get(curChar);
      if (code == null) {
        codes.put(curChar, i++);
      } else {
        codes.put(curChar, code);
      }
      sb.append(code);
    }

    return sb.toString();
  }

  public List<String> findAndReplacePatternOld(String[] words, String pattern) {
    List<String> matchedWords = new ArrayList<>();
    for (String word : words) {
      if (word.length() != pattern.length()) {
        continue;
      }

      Map<Integer, Integer> patternCodes = new HashMap<>();
      Map<Integer, Integer> wordCodes = new HashMap<>();

      boolean matched = true;

      for (int i = 0; i < word.length(); i++) {
        int patternCode = Character.getNumericValue(pattern.charAt(i));
        int wordCode = Character.getNumericValue(word.charAt(i));

        Integer patternCodeMapping = patternCodes.get(patternCode);
        Integer wordCodeMapping = wordCodes.get(wordCode);

        if (patternCodeMapping == null) {
          patternCodes.put(patternCode, wordCode);
        }
        if (wordCodeMapping == null) {
          wordCodes.put(wordCode, patternCode);
        }

        if (patternCodeMapping != null && patternCodeMapping != wordCode) {
          matched = false;
          break;
        }
        if (wordCodeMapping != null && wordCodeMapping != patternCode) {
          matched = false;
          break;
        }
      }

      if (matched) {
        matchedWords.add(word);
      }
    }

    return matchedWords;
  }
}
