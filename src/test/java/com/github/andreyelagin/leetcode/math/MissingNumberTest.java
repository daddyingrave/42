package com.github.andreyelagin.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

  MissingNumber missingNumber = new MissingNumber();
  
  @Test
  void missingNumber() {
//    assertEquals(2, missingNumber.missingNumber(new int[]{3, 0, 1}));
    assertEquals(2, missingNumber.missingNumber(new int[]{0, 1}));
  }
}