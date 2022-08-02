package com.github.daddyingrave.leetcode.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderDataInLogFilesTest {

  ReorderDataInLogFiles solution = new ReorderDataInLogFiles();

  @Test
  void reorderLogFiles() {
    assertArrayEquals(
        new String[]{"let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"},
        solution.reorderLogFiles(
            new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"}
        )
    );
    assertArrayEquals(
        new String[]{"g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"},
        solution.reorderLogFiles(
            new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"}
        )
    );
    assertArrayEquals(
        new String[]{"a2 act car","g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"},
        solution.reorderLogFiles(
            new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"}
        )
    );
  }
}