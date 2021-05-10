package com.github.andreyelagin.backtobackswe.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceWordsWithPrefixTest {

  ReplaceWordsWithPrefix replaceWordsWithPrefix = new ReplaceWordsWithPrefix();

  @Test
  void replaceWordsWithPrefix() {
    assertEquals(
        "The cat were cat yarn",
        replaceWordsWithPrefix.replaceWordsWithPrefix(
            new String[]{"cat", "catch", "Alabama"},
            "The cats were catching yarn"
        )
    );
  }
}