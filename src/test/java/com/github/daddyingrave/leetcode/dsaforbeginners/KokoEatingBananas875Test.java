package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KokoEatingBananas875Test {
  public int minEatingSpeed(int[] piles, int h) {
    int upperK = piles[0];
    for (int i = 1; i < piles.length; i++) {
      if (upperK < piles[i]) {
        upperK = piles[i];
      }
    }

    int minHours = upperK;
    int left = 1;
    int right = upperK;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (canEat(piles, h, mid)) {
        right = mid - 1;
        minHours = Math.min(mid, minHours);
      } else {
        left = mid + 1;
      }
    }

    return minHours;
  }

  boolean canEat(int[] piles, int hours, int eatRate) {
    int hoursConsumed = 0;
    for (int pile : piles) {
      if (pile % eatRate != 0) {
        hoursConsumed += 1;
      }
      hoursConsumed += pile / eatRate;
      if (hoursConsumed > hours) {
        return false;
      }
    }

    return true;
  }

  @Test
  void test() {
    assertEquals(4, minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    assertEquals(23, minEatingSpeed(new int[]{30,11,23,4,20}, 6));
  }
}
