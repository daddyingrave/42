package com.github.andreyelagin.ctci.arraysandstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsUniqueTest {

  IsUnique isUnique = new IsUnique();
  
  @Test
  void allUnique() {
    assertTrue(isUnique.allUnique("qwerty"));
    assertTrue(isUnique.allUnique(""));
    assertFalse(isUnique.allUnique("qwertyq"));
  }
}