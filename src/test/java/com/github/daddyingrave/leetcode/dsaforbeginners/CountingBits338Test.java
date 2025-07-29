package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountingBits338Test {
  public int[] countBits(int n) {
    int[] result = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      int val = i;
      int count = 0;
      while (val > 0) {
        if ((val & 1) == 1) {
          count++;
        }
        val = val >> 1;
      }

      result[i] = count;
    }

    return result;
  }

  @Test
  void test() {
    assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, countBits(5));
  }
}
