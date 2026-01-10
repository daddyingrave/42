package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MatchstickstoSquare473Test {
  class Solution {
    public boolean makesquare(int[] matchsticks) {
      int totalLength = Arrays.stream(matchsticks).sum();
      if (totalLength % 4 != 0) {
        return false;
      }

      matchsticks = Arrays.stream(matchsticks).
          boxed().
          sorted(Comparator.reverseOrder()).
          mapToInt(Integer::intValue).toArray();

      return backtrack(0, totalLength / 4, new int[4], matchsticks);
    }

    boolean backtrack(int index, int length, int[] sides, int[] matchsticks) {
      if (index == matchsticks.length) {
        return true;
      }

      for (int i = 0; i < 4; i++) {
        if (sides[i] + matchsticks[index] <= length) {
          sides[i] += matchsticks[index];
          if (backtrack(index + 1, length, sides, matchsticks)) {
            return true;
          }
          sides[i] -= matchsticks[index];
        }

        if (sides[i] == 0) {
          break;
        }
      }

      return false;
    }
  }

  @Test
  void test() {

  }
}
