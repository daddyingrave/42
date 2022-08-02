package com.github.daddyingrave.backtobackswe.recursionbacktracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

  Permutations permutations = new Permutations();

  @Test
  void permute() {
    var expected = List.of(
        List.of(1, 2, 3),
        List.of(1, 3, 2),
        List.of(2, 1, 3),
        List.of(2, 3, 1),
        List.of(3, 1, 2),
        List.of(3, 2, 1)
    );

    assertTrue(expected.containsAll(permutations.permute(new int[]{1, 2, 3})));
  }
}
