package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class SimplifyPath71Test {
  class Solution {
    // /home/
    public String simplifyPath(String path) {
      var stack = new Stack<String>();
      int i = 0;

      while (i < path.length()) {
        while (i < path.length() && path.charAt(i) == '/') {
          i++;
        }
        if (i == path.length()) {
          break;
        }

        var curDir = new StringBuilder();
        while (i < path.length() && path.charAt(i) != '/') {
          curDir.append(path.charAt(i));
          i++;
        }

        String curDirString = curDir.toString();
        if (curDirString.equals("..")) {
          if (!stack.isEmpty()) {
            stack.pop();
          }
        } else if (!curDirString.equals(".")) {
          stack.push(curDirString);
        }
      }

      var result = new StringBuilder();
      result.append("/");
      for (int j = 0; j < stack.size(); j++) {
        result.append(stack.get(j));
        if (j != stack.size() - 1) {
          result.append("/");
        }
      }

      return result.toString();
    }
  }

  @Test
  void test() {
    assertEquals("/home", new Solution().simplifyPath("/home/"));
    assertEquals("/home/foo", new Solution().simplifyPath("/home//foo/"));
    assertEquals("/home/user/Pictures", new Solution().simplifyPath("/home/user/Documents/../Pictures"));
    assertEquals("/", new Solution().simplifyPath("/../"));
    assertEquals("/.../b/d", new Solution().simplifyPath("/.../a/../b/c/../d/./"));
  }
}
