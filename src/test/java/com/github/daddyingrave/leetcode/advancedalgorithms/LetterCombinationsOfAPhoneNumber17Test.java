package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber17Test {
  class Solution {
    char[][] letters = new char[][]{
        {},
        {},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
      if (digits.isEmpty()) {
        return List.of();
      }

      var result = new ArrayList<String>();
      int[] nums = new int[digits.length()];
      for (int i = 0; i < digits.length(); i++) {
        nums[i] = digits.charAt(i) - '0';
      }

      backtrack(0, nums, new StringBuilder(), result);

      return result;
    }

    void backtrack(
        int digitPtr,
        int[] digits,
        StringBuilder cur,
        List<String> result
    ) {
      if (cur.length() == digits.length) {
        result.add(cur.toString());
        return;
      }
      if (digitPtr >= digits.length) {
        return;
      }

      for (char ch : letters[digits[digitPtr]]) {
        cur.append(ch);
        backtrack(digitPtr + 1, digits, cur, result);
        cur.deleteCharAt(cur.length() - 1);
      }
    }
  }

  @Test
  void test() {
    var res = new Solution().letterCombinations("23");
    System.out.println(res);
  }
}
