package com.github.daddyingrave.leetcode.repeat;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MyHashSetTest {

  public int longestConsecutive(int[] nums) {
    var set = new HashSet<Integer>();
    int seqLength = 0;

    for (int num : nums) {
      set.add(num);
    }

    for (int num : set) {
      if (!set.contains(num - 1)) {
        int curLength = 1;
        while (set.contains(num + curLength)) {
          curLength++;
        }

        seqLength = Math.max(seqLength, curLength);
      }
    }

    return seqLength;
  }

  @Test
  void test() {

  }
}
