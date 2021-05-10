package com.github.andreyelagin.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

  ValidPalindrome validPalindrome = new ValidPalindrome();
  
  @Test
  void validPalindrome() {
    assertTrue(validPalindrome.validPalindrome("Race Car"));
  }
}