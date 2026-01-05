package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GenerateParentheses22V2Test {
  class Solution {
    public List<String> generateParenthesis(int n) {
      var result = new ArrayList<String>();
      backtrack(0, 0, n, new StringBuilder(), result);
      return result;
    }

    void backtrack(int open, int closed, int n, StringBuilder cur, List<String> result) {
      if (open == closed && closed == n) {
        result.add(cur.toString());
        return;
      }

      if (open < n) {
        cur.append("(");
        backtrack(open + 1, closed, n, cur, result);
        cur.deleteCharAt(cur.length() - 1);
      }

      if (closed < open) {
        cur.append(")");
        backtrack(open, closed + 1, n, cur, result);
        cur.deleteCharAt(cur.length() - 1);
      }
    }
  }

  @Test
  void test() {

  }
}
