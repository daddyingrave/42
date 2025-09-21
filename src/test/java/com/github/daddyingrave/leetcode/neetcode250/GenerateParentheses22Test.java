package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22Test {
  class Solution {
    public List<String> generateParenthesis(int n) {
      ArrayList<String> result = new ArrayList<>();

      backtrack(0, 0, n, new StringBuilder(), result);
      return result;
    }

    void backtrack(
        int open,
        int closed,
        int max,
        StringBuilder cur,
        List<String> result
    ) {
      if (cur.length() == max * 2) {
        result.add(cur.toString());
        return;
      }

      if (open < max) {
        cur.append("(");
        backtrack(open + 1, closed, max, cur, result);
        cur.deleteCharAt(cur.length() - 1);
      }

      if (closed < open) {
        cur.append(")");
        backtrack(open, closed + 1, max, cur, result);
        cur.deleteCharAt(cur.length() - 1);
      }
    }
  }

  @Test
  void test() {
    new Solution().generateParenthesis(3);
  }
}
