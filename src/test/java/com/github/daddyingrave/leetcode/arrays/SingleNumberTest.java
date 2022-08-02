package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

  SingleNumber singleNumber = new SingleNumber();

  @Test
  void singleNumber() {
    assertEquals(1, singleNumber.singleNumber(new int[]{2, 2, 1}));
    assertEquals(4, singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));
  }
}