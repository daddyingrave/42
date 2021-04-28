package com.github.andreyelagin.backtobackswe.primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTest {

  @Test
  void reverseBits() {
    System.out.println(Integer.toBinaryString(100));
    assertEquals(
        Integer.toBinaryString(19), 
        Integer.toBinaryString(ReverseBits.reverseBits(100))
    );
//    assertEquals(
//        Integer.toBinaryString(111), 
//        Integer.toBinaryString(ReverseBits.reverseBits(123))
//    );
//    assertEquals(
//        Integer.toBinaryString(123431767), 
//        Integer.toBinaryString(ReverseBits.reverseBits(123123415))
//    );
  }
}