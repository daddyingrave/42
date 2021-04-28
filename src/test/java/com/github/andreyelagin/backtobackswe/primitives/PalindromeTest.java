package com.github.andreyelagin.backtobackswe.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

  @Test
  void isPalindrome() {
    assertTrue(Palindrome.isPalindrome(123321));
    assertTrue(Palindrome.isPalindrome(1));
    assertTrue(Palindrome.isPalindrome(0));
    assertTrue(Palindrome.isPalindrome(1234321));
  }
}