package com.github.andreyelagin.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatternMatchingTest {

  PatternMatching patternMatching = new PatternMatching();

  @Test
  void findAndReplacePattern() {
    assertEquals(
        List.of("aa", "bb"),
        patternMatching.findAndReplacePattern(new String[]{"aa", "bb"}, "cc")
    );
    assertEquals(
        List.of(),
        patternMatching.findAndReplacePattern(new String[]{"aa", "bb"}, "zy")
    );
    assertEquals(
        List.of("bcb", "yzy"),
        patternMatching.findAndReplacePattern(new String[]{"aac", "bbc", "bcb", "yzy"}, "ghg")
    );
    assertEquals(
        List.of("zzz"),
        patternMatching.findAndReplacePattern(new String[]{"abc","cde","zzz"}, "aaa")
    );
    assertEquals(
        List.of("ka"),
        patternMatching.findAndReplacePattern(new String[]{"xx","yy","ka"}, "ba")
    );
  }
}