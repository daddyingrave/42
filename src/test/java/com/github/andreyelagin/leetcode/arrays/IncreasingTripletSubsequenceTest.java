package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncreasingTripletSubsequenceTest {

  IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();

  @Test
  void increasingTriplet() {
    assertTrue(increasingTripletSubsequence.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
    assertFalse(increasingTripletSubsequence.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    assertTrue(increasingTripletSubsequence.increasingTriplet(new int[]{2, 1, 5, 0, 4, 65}));
  }
}