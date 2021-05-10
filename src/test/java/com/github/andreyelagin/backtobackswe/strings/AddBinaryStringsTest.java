package com.github.andreyelagin.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddBinaryStringsTest {

  AddBinaryStrings addBinaryStrings = new AddBinaryStrings();

  @Test
  void addBinaryStrings() {
    assertEquals("110", addBinaryStrings.addBinaryStrings("101", "1"));
    assertEquals("10", addBinaryStrings.addBinaryStrings("1", "1"));
    assertEquals(
        "1000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111",
        addBinaryStrings.addBinaryStrings(
            "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111",
            "100000000000000000000000000000000000000000000"
        )
    );
  }
}