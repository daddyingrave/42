package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class DecodeString394Test {
  class Solution {
    public String decodeString(String s) {
      var wordStack = new Stack<String>();
      var countStack = new Stack<Integer>();
      var curWord = new StringBuilder();
      int count = 0;

      for (int j = 0; j < s.length(); j++) {
        char ch = s.charAt(j);

        if (Character.isDigit(ch)) {
          count = count * 10 + (ch - '0');
        } else if (ch == '[') {
          wordStack.push(curWord.toString());
          curWord = new StringBuilder();

          countStack.push(count);
          count = 0;
        } else if (ch == ']') {
          String tmp = curWord.toString();
          curWord = new StringBuilder();
          curWord.append(wordStack.pop());

          Integer repeats = countStack.pop();
          curWord.append(tmp.repeat(repeats));
        } else {
          curWord.append(ch);
        }

      }

      return curWord.toString();
    }
  }

  @Test
  void test() {
    assertEquals("aaabcbc", new Solution().decodeString("3[a]2[bc]"));
    assertEquals("accaccacc", new Solution().decodeString("3[a2[c]]"));
  }
}
