package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicDecompositionsTest {

  PalindromicDecompositions decompositions = new PalindromicDecompositions();
  
  @Test
  void partition() {
    var expected = List.of(
        List.of("a", "a", "b"),
        List.of("aa", "b")
    );
    assertEquals(expected, decompositions.partition("aab"));
  }
}