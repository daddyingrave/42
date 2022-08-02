package com.github.daddyingrave.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrlifyTest {

  Urlify urlify = new Urlify();

  @Test
  void urlEncode() {
    assertArrayEquals(
        new char[]{'a', '%', '2', '0', 'v', 'a'},
        urlify.urlEncode(
            new char[]{'a', ' ', 'v', 'a', ' ', ' '},
            3
        )
    );
    assertArrayEquals(
        new char[]{'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h'},
        urlify.urlEncode(
            new char[]{'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '},
            13
        )
    );
  }
}