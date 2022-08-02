package com.github.daddyingrave.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigzagConversionTest {

  ZigzagConversion zigzagConversion = new ZigzagConversion();

  @Test
  void zigzag() {
    assertEquals("YPEWILONLK", zigzagConversion.zigzag("YELLOWPINK", 4));
    assertEquals("RDLELCEBUBAK", zigzagConversion.zigzag("REDBLUEBLACK", 2));
    assertEquals("REDBLUEBLACK", zigzagConversion.zigzag("REDBLUEBLACK", 1));
  }
}