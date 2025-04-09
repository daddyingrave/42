package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static com.github.daddyingrave.leetcode.Utils.arrayToSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TopKFrequentElements347Test {

  @Test
  void topKFrequent() {
    var problem = new TopKFrequentElements347();

    assertEquals(
        arrayToSet(new int[]{1, 2}),
        arrayToSet(problem.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))
    );
    assertEquals(
        arrayToSet(new int[]{1}),
        arrayToSet(problem.topKFrequent(new int[]{1}, 1))
    );
  }
}
