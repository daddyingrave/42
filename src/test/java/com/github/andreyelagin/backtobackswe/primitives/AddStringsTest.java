package com.github.andreyelagin.backtobackswe.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddStringsTest {

  @Test
  void addStrings() {
    assertEquals("102", AddStrings.addStrings("101", "1"));
    assertEquals("333", AddStrings.addStrings("111", "222"));
    assertEquals("1100", AddStrings.addStrings("500", "600"));
  }
}