package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromePartitioning131Test {
  class Solution {
    public List<List<String>> partition(String s) {
      var result = new ArrayList<List<String>>();
      backtrack(0, 0, s, new ArrayList<>(), result);
      return result;
    }

    void backtrack(int left, int right, String s, List<String> part, List<List<String>> result) {
      if (right >= s.length()) {
        if (left == right) {
          result.add(new ArrayList<>(part));
        }
        return;
      }

      if (isPalindrome(left, right, s)) {
        part.add(s.substring(left, right + 1));
        backtrack(right + 1, right + 1, s, part, result);
        part.remove(part.size() - 1);
      }

      backtrack(left, right + 1, s, part, result);
    }

    boolean isPalindrome(int left, int right, String s) {
      while (left < right) {
        if (s.charAt(left++) != s.charAt(right--)) {
          return false;
        }
      }

      return true;
    }
  }

  @Test
  void test() {

  }
}
