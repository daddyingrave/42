package com.github.daddyingrave.backtobackswe.hashtables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NearestRepeatedEntriesInArrayTest {

  NearestRepeatedEntriesInArray repeatedEntriesInArray = new NearestRepeatedEntriesInArray();

  @Test
  void distanceOfClosestRepeatedEntries() {
    assertEquals(
        2,
        repeatedEntriesInArray.distanceOfClosestRepeatedEntries(
            new String[]{
                "This",
                "is",
                "a",
                "sentence",
                "with",
                "is",
                "repeated",
                "then",
                "repeated"
            }
        )
    );
  }
}