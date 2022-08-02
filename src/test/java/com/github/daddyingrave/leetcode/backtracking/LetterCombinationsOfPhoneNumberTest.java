package com.github.daddyingrave.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfPhoneNumberTest {

  LetterCombinationsOfPhoneNumber solution = new LetterCombinationsOfPhoneNumber();
  
  @Test
  void letterCombinations() {
    assertEquals(
        List.of(
            "ad","ae","af","bd","be","bf","cd","ce","cf"
        ),
        solution.letterCombinations("23")
    );
    assertEquals(
        List.of(
            "a","b","c"
        ),
        solution.letterCombinations("2")
    );
    assertEquals(
        List.of(),
        solution.letterCombinations("")
    );
  }
}