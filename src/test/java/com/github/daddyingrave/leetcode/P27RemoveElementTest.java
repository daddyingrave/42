package com.github.daddyingrave.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P27RemoveElementTest {

  @Test
  void removeElement() {
    var problem = new P27RemoveElement();

    int[] nums = {3, 2, 2, 3};
    int i = problem.removeElement(nums, 3);


    assertArrayEquals(new int[]{2, 2, 3, 3}, nums);
    assertEquals(2, i);
  }

  @Test
  void removeElement2() {
    var problem = new P27RemoveElement();

    int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
    int i = problem.removeElement(nums, 2);


    assertArrayEquals(new int[]{0, 1, 4, 0, 3}, nums);
    assertEquals(2, i);
  }
}