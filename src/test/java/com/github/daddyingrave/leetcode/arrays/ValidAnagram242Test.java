package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagram242Test {

  @Test
  void isAnagram() {
    var problem = new ValidAnagram242();

    assertTrue(problem.isAnagram("anagram", "nagaram"));

    assertFalse(problem.isAnagram("rat", "car"));
  }
}
