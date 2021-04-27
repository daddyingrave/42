package com.github.andreyelagin.backtobackswe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangingBaseTest {

  @Test
  void changeBase() {
    assertEquals("1100", ChangingBase.changeBase("12", 10, 2)); 
    assertEquals("27", ChangingBase.changeBase("123", 4, 10)); 
    assertEquals("1B", ChangingBase.changeBase("123", 4, 16)); 
    assertEquals("123", ChangingBase.changeBase("123", 10, 10)); 
  }
}