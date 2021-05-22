package com.github.andreyelagin.backtobackswe.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedParenthesesProblemTest {

  BalancedParenthesesProblem balancedParentheses = new BalancedParenthesesProblem();
  
  @Test
  void isValid() {
    assertTrue(balancedParentheses.isValid("()"));
    assertTrue(balancedParentheses.isValid("((([[]])))"));
    assertFalse(balancedParentheses.isValid("())"));
    assertFalse(balancedParentheses.isValid("((([[)))"));
    assertFalse(balancedParentheses.isValid("((((((((((((((((({{{{{{{{{{{{{{{{{{{{{{{{[[[[[[[[[[[[[[[[[[[[[[((((((({{{{{{{{{{[[[[[[[[[[[[[[[[[[[[[[[[[[[[[((((((((((((({{{{{{{{{{{{{{{"));
  }
}