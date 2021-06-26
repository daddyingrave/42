package com.github.andreyelagin.backtobackswe.dynamicprogramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayProductTest {

  ArrayProduct arrayProduct = new ArrayProduct();
  
  @Test
  void productExceptCurrentElement() {
    assertArrayEquals(
        new int[]{10, 10, 5, 2},
        arrayProduct.productExceptCurrentElement(new int[]{1, 1, 2, 5})
    );
  }
}