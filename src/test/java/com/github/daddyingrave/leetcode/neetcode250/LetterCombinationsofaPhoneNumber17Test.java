package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LetterCombinationsofaPhoneNumber17Test {
  class Solution {
    char[][] letters = new char[][]{
        {}, {},
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
      var result = new ArrayList<String>();
      backtrack(0, digits, "", result);
      return result;
    }

    void backtrack(int digit, String digits, String cur, List<String> result) {
      if (cur.length() == digits.length()) {
        result.add(cur);
        return;
      }

      char[] curLetters = letters[digits.charAt(digit) - '0'];
      for (char curLetter : curLetters) {
        backtrack(digit + 1, digits, cur + curLetter, result);
      }
    }
  }

  @Test
  void test() {

  }
}
