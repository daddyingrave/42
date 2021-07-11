package com.github.andreyelagin.leetcode.arrays;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

  private int[] nums;
  private int[] copy;
  private final Random random = new Random();

  public ShuffleArray(int[] nums) {
    this.nums = nums;
    this.copy = nums.clone();
  }

  public int[] reset() {
    copy = nums;
    nums = nums.clone();
    return nums;
  }

  public int[] shuffle() {
    for (int i = 0; i < copy.length; i++) {
      int idx = random.nextInt(copy.length - i) + i;
      int tmp = copy[i];
      copy[i] = copy[idx];
      copy[idx] = tmp;
    }
    return copy;
  }
}
