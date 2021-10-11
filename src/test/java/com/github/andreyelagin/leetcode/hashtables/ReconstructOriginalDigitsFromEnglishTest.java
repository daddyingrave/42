package com.github.andreyelagin.leetcode.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructOriginalDigitsFromEnglishTest {

  ReconstructOriginalDigitsFromEnglish solution = new ReconstructOriginalDigitsFromEnglish();

  @Test
  void originalDigits() {
    assertEquals("012", solution.originalDigits("owoztneoer"));
    assertEquals("45", solution.originalDigits("fviefuro"));
    assertEquals("0123456789", solution.originalDigits("zeroonetwothreefourfivesixseveneightnine"));
  }
}