package com.github.andreyelagin.backtobackswe.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumRemovalsValidStringTest {

  MinimumRemovalsValidString validString = new MinimumRemovalsValidString();
  
  @Test
  void makeStringValid() {
    assertEquals("ab(c)d", validString.makeStringValid("a)b(c)d"));
    assertEquals("a((c(d)))a(())", validString.makeStringValid("a((c(d)))a(()))"));
    assertEquals("", validString.makeStringValid("((((((((((((("));
  }
}