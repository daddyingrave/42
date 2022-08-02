package com.github.daddyingrave.leetcode.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStringsTest {

  AddStrings solution = new AddStrings();
  
  @Test
  void addStrings() {
    assertEquals("134", solution.addStrings("11", "123"));
    assertEquals("533", solution.addStrings("456", "77")); 
    assertEquals("0", solution.addStrings("0", "0")); 
  }
}