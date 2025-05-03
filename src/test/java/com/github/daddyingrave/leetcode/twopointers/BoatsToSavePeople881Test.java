package com.github.daddyingrave.leetcode.twopointers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BoatsToSavePeople881Test {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int result = 0;

    int left = 0;
    int right = people.length - 1;
    while (left <= right) {
      if (people[right] + people[left] <= limit) {
        left++;
      }
      right--;

      result++;
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(1, numRescueBoats(new int[]{1, 2}, 3));
    assertEquals(3, numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    assertEquals(4, numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    assertEquals(2, numRescueBoats(new int[]{5, 1, 4, 2}, 6));
    assertEquals(4, numRescueBoats(new int[]{5, 1, 7, 4, 2, 4}, 7));
  }
}
