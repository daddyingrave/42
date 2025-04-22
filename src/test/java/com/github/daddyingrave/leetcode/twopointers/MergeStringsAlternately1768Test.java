package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeStringsAlternately1768Test {
  public String mergeAlternately(String word1, String word2) {
    var sb = new StringBuilder();

    int w1Ptr = 0;
    int w2Ptr = 0;
    boolean coin = true;
    while (w1Ptr < word1.length() && w2Ptr < word2.length()) {
      if (coin) {
        sb.append(word1.charAt(w1Ptr++));
        coin = false;
      } else {
        sb.append(word2.charAt(w2Ptr++));
        coin = true;
      }
    }

    while (w1Ptr < word1.length()) {
      sb.append(word1.charAt(w1Ptr++));
    }
    while (w2Ptr < word2.length()) {
      sb.append(word2.charAt(w2Ptr++));
    }

    return sb.toString();
  }

  @Test
  void test() {
    assertEquals("apbqcr", mergeAlternately("abc", "pqr"));
    assertEquals("apbqrs", mergeAlternately("ab", "pqrs"));
    assertEquals("apbqcd", mergeAlternately("abcd", "pq"));
  }
}
