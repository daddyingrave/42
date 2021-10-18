package com.github.andreyelagin.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicCalculatorIITest {

  BasicCalculatorII solution = new BasicCalculatorII();
  
  @Test
  void calculate() {
//    assertEquals(7, solution.calculate("3+2*2"));
//    assertEquals(1, solution.calculate(" 3/2 "));
//    assertEquals(5, solution.calculate(" 3+5 / 2 "));
    assertEquals(10, solution.calculate("             3     +    2 /1 *8   -9 +4/8"));
    assertEquals(1, solution.calculate("1-1+1"));
  }
}