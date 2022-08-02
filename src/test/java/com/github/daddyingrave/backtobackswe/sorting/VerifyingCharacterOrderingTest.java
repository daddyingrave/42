package com.github.daddyingrave.backtobackswe.sorting;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VerifyingCharacterOrderingTest {

  VerifyingCharacterOrdering ordering = new VerifyingCharacterOrdering();
  
  @Test
  void verifyOrdering() {
    assertTrue(
        ordering.verifyOrdering(
            List.of("hello", "hey", "a"),
            "hlbcdefgijkmnopqrstuvwxzya"
        )
    );
    assertFalse(
        ordering.verifyOrdering(
            List.of("abcd","abc"),
            "abcdefghijklmnopqrstuvwxyz"
        )
    );
  }
}