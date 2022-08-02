package com.github.daddyingrave.leetcode.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {

  GroupAnagrams problem = new GroupAnagrams();

  @Test
  void groupAnagrams() {
    assertEquals(
        List.of(
            List.of("tan", "nat"),
            List.of("eat", "tea", "ate"),
            List.of("bat")
        ),
        problem.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})
    );
    assertEquals(
        List.of(
            List.of("")
        ),
        problem.groupAnagrams(new String[]{""})
    );
    assertEquals(
        List.of(
            List.of("a")
        ),
        problem.groupAnagrams(new String[]{"a"})
    );
  }
}