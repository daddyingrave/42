package com.github.daddyingrave.leetcode.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

  LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

  @Test
  void longestCommonPrefix() {
    assertEquals(
        "fl",
        longestCommonPrefix.longestCommonPrefix(
            new String[]{"flower", "flow", "flight"}
        )
    );
    assertEquals(
        "",
        longestCommonPrefix.longestCommonPrefix(
            new String[]{"dog", "racecar", "car"}
        )
    );
  }
}