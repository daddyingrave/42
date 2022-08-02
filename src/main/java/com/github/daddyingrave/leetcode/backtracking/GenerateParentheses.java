package com.github.daddyingrave.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
  public List<String> generateParenthesis(int n) {
    var result = new ArrayList<String>();
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
  }
  
  private void backtrack(List<String> result, StringBuilder buf, int open, int closed, int max) {
    if (buf.length() == max * 2) {
      result.add(buf.toString());
      return;
    }
    
    if (open < max) {
      buf.append('(');
      backtrack(result, buf, open + 1, closed, max);
      buf.deleteCharAt(buf.length() - 1);
    }
    if (closed < open) {
      buf.append(')');
      backtrack(result, buf, open, closed + 1, max);
      buf.deleteCharAt(buf.length() - 1);
    }
  }
}
