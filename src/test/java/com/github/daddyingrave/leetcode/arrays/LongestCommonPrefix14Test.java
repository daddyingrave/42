package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefix14Test {

  @Test
  void longestCommonPrefix() {
    var problem = new LongestCommonPrefix14();

//    assertEquals("fl", problem.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//    assertEquals("", problem.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
//    assertEquals("a", problem.longestCommonPrefix(new String[]{"a"}));
//    assertEquals("c", problem.longestCommonPrefix(new String[]{"cir","car"}));
    assertEquals("a", problem.longestCommonPrefix(new String[]{"ab", "a"}));
  }
}
