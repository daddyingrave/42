package com.github.andreyelagin.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountPrimesTest {

  CountPrimes countPrimes = new CountPrimes();
  
  @Test
  void countPrimes() {
    assertEquals(4, countPrimes.countPrimes(10));
  }
}