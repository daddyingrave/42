package com.github.daddyingrave.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupAnagramsTest {

  GroupAnagrams groupAnagrams = new GroupAnagrams();
  
  @Test
  void groupAnagrams() {
    assertEquals(
        List.of(
            List.of("bat", "tab"),
            List.of("eat", "ate", "tea", "eat")
        ),
        groupAnagrams.groupAnagrams(List.of("eat", "bat", "ate", "tab", "tea", "eat"))
    );
  }
}