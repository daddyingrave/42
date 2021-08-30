package com.github.andreyelagin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationTest {

  PalindromePermutation palindromePermutation = new PalindromePermutation();
  
  @Test
  void isPalindromePermutation() {
    assertTrue(palindromePermutation.isPalindromePermutation("Tact Coa"));
    assertTrue(palindromePermutation.isPalindromePermutation("aaaa"));
    assertTrue(palindromePermutation.isPalindromePermutation("aaaba"));
    assertFalse(palindromePermutation.isPalindromePermutation("aaabae"));
  }
}