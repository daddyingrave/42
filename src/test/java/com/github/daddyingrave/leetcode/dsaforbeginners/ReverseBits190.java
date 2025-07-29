package com.github.daddyingrave.leetcode.dsaforbeginners;

public class ReverseBits190 {
  public int reverseBits(int n) {
    int res = 0;

    for (int i = 0; i <= 31; i++) {
      if (((n >> i) & 1) == 1) {
        res |= (1 << (31 - i));
      }
    }

    return res;
  }
}
