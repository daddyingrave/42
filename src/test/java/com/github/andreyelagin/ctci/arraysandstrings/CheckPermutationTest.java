package com.github.andreyelagin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckPermutationTest {

  CheckPermutation checkPermutation = new CheckPermutation();
  
  @Test
  void permutation() {
    assertTrue(checkPermutation.permutation("abab", "baba"));
    assertFalse(checkPermutation.permutation("ababq", "babaw"));
  }
}