package com.github.daddyingrave.backtobackswe.recursionbacktracking;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenerateThePowersetTest {

  GenerateThePowerset powerset = new GenerateThePowerset();

  @Test
  void powerset() {
    var expected = Set.of(
        List.of(),
        List.of(1, 2, 3),
        List.of(1, 2),
        List.of(1, 3),
        List.of(1),
        List.of(2, 3),
        List.of(2),
        List.of(3)
    );
    var actual = powerset.powerset(new int[]{1, 2, 3});
    assertTrue(expected.containsAll(actual));
  }
}
