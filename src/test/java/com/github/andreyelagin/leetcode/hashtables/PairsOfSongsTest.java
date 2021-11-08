package com.github.andreyelagin.leetcode.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairsOfSongsTest {

  PairsOfSongs solution = new PairsOfSongs();

  @Test
  void numPairsDivisibleBy60() {
    assertEquals(3, solution.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    assertEquals(3, solution.numPairsDivisibleBy60(new int[]{60, 60, 60}));
    assertEquals(0, solution.numPairsDivisibleBy60(new int[]{439, 407, 197, 191, 291, 486, 30, 307, 11}));
  }
}
