package com.github.andreyelagin.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllPrimesToNTest {

  AllPrimesToN primes = new AllPrimesToN();

  @Test
  void enumeratePrimes() {
    assertEquals(List.of(), primes.enumeratePrimes(1));
    assertEquals(List.of(2, 3, 5, 7, 11, 13, 17, 19), primes.enumeratePrimes(23));
  }
}