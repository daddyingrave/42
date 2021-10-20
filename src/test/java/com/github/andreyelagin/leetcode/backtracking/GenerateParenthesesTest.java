package com.github.andreyelagin.leetcode.backtracking;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

  GenerateParentheses solution = new GenerateParentheses();

  @Test
  void generateParenthesis() {
    assertEquals(
        Set.of("((()))", "(()())", "(())()", "()(())", "()()()"), 
        new HashSet<>(solution.generateParenthesis(3))
    );
  }
}