package com.github.daddyingrave.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordSubsetsTest {

  WordSubsets wordSubsets = new WordSubsets();

  @Test
  void wordSubsets() {
    assertEquals(
        List.of("room"),
        wordSubsets.wordSubsets(
            List.of("orange", "room", "more"),
            List.of("rm", "oo")
        )
    );
    assertEquals(
        List.of("css", "randomcs"),
        wordSubsets.wordSubsets(
            List.of("padding", "css", "randomcs"),
            List.of("cs", "c")
        )
    );
  }
}