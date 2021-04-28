package com.github.andreyelagin.backtobackswe.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfFourTest {

  @Test
  void powerOfFour() {
    assertTrue(PowerOfFour.powerOfFour((int) Math.pow(4, 2)));
    assertTrue(PowerOfFour.powerOfFour((int) Math.pow(4, 3)));
    assertTrue(PowerOfFour.powerOfFour((int) Math.pow(4, 4)));
    assertTrue(PowerOfFour.powerOfFour((int) Math.pow(4, 5)));
    assertTrue(PowerOfFour.powerOfFour((int) Math.pow(4, 6)));

    assertFalse(PowerOfFour.powerOfFour(3));
    assertFalse(PowerOfFour.powerOfFour(18));
    assertFalse(PowerOfFour.powerOfFour(21));
  }
}