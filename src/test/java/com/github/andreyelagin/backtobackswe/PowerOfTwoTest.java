package com.github.andreyelagin.backtobackswe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerOfTwoTest {

  @Test
  void powerOfTwo() {
    assertTrue(PowerOfTwo.powerOfTwo(1));
    assertTrue(PowerOfTwo.powerOfTwo(1024));
    assertTrue(PowerOfTwo.powerOfTwo(2));
    assertTrue(PowerOfTwo.powerOfTwo(64));
    assertTrue(PowerOfTwo.powerOfTwo(128));
    assertFalse(PowerOfTwo.powerOfTwo(127));
    assertFalse(PowerOfTwo.powerOfTwo(-2));
    assertFalse(PowerOfTwo.powerOfTwo(12341));
  }

  @Test
  void myStupidSolution() {
    assertTrue(PowerOfTwo.myStupidSolution(1));
    assertTrue(PowerOfTwo.myStupidSolution(1024));
    assertTrue(PowerOfTwo.myStupidSolution(2));
    assertTrue(PowerOfTwo.myStupidSolution(64));
    assertTrue(PowerOfTwo.myStupidSolution(128));
    assertFalse(PowerOfTwo.myStupidSolution(127));
    assertFalse(PowerOfTwo.myStupidSolution(-2));
    assertFalse(PowerOfTwo.myStupidSolution(12341));
  }
}