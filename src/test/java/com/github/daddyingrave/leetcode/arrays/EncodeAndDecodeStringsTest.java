package com.github.daddyingrave.leetcode.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncodeAndDecodeStringsTest {

  @Test
  void encode() {
    var problem = new EncodeAndDecodeStrings();

    assertEquals(
        List.of("neet", "code", "love", "you"),
        problem.decode(problem.encode(List.of("neet", "code", "love", "you")))
    );
    assertEquals(
        List.of(""),
        problem.decode(problem.encode(List.of("")))
    );
    assertEquals(
        List.of(),
        problem.decode(problem.encode(List.of()))
    );
  }
}
