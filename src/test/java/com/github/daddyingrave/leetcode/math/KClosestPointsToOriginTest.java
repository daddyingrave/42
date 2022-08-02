package com.github.daddyingrave.leetcode.math;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class KClosestPointsToOriginTest {

  KClosestPointsToOrigin solution = new KClosestPointsToOrigin();

  @Test
  void kClosest() {
    assertEquals(
        toSet(new int[][]{new int[]{-2, 2}}),
        toSet(solution.kClosest(new int[][]{new int[]{1, 3}, new int[]{-2, 2}}, 1)));

    assertEquals(
        toSet(new int[][]{new int[]{-2, 4}, new int[]{3, 3}}),
        toSet(solution.kClosest(new int[][]{new int[]{3, 3}, new int[]{5, -1}, new int[]{-2, 4}}, 2)));
  }
  
  private Set<List<Integer>> toSet(int[][] points) {
    return Arrays
        .stream(points)
        .map(arr -> Arrays.asList(arr[0], arr[1]))
        .collect(Collectors.toSet());
  }
}