package com.github.daddyingrave.backtobackswe.recursionbacktracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditiveSequenceTest {

  AdditiveSequence additiveSequence = new AdditiveSequence();
  
  @Test
  void isAdditiveNumber() {
    assertTrue(additiveSequence.isAdditiveNumber("347111829"));
    assertTrue(additiveSequence.isAdditiveNumber("15051101152"));
    assertFalse(additiveSequence.isAdditiveNumber("15141161152"));
  }
}