package com.github.andreyelagin.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExcelSheetColumnNumberTest {

  ExcelSheetColumnNumber solution = new ExcelSheetColumnNumber();
  
  @Test
  void titleToNumber() {
    assertEquals(1, solution.titleToNumber("A"));
    assertEquals(28, solution.titleToNumber("AB"));
    assertEquals(701, solution.titleToNumber("ZY"));
    assertEquals(2147483647, solution.titleToNumber("FXSHRXW"));
  }
}