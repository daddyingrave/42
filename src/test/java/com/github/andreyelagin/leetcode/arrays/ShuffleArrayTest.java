package com.github.andreyelagin.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ShuffleArrayTest {
  
  @Test
  void shuffle() {
    var source = new int[]{1, 2, 3, 4};
    var shuffle = new ShuffleArray(source);
    var shuffled = shuffle.shuffle();
    assertNotEquals(
        Arrays.stream(source).boxed().collect(Collectors.toList()),
        Arrays.stream(shuffled).boxed().collect(Collectors.toList())
    );
  }
}