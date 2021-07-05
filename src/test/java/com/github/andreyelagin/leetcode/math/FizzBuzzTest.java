package com.github.andreyelagin.leetcode.math;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

  FizzBuzz fizzBuzz = new FizzBuzz();

  @Test
  void fizzBuzz() {
    assertEquals(List.of("1", "2", "Fizz"), fizzBuzz.fizzBuzz(3));
    assertEquals(List.of("1", "2", "Fizz", "4", "Buzz"), fizzBuzz.fizzBuzz(5));
    assertEquals(
        List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"), 
        fizzBuzz.fizzBuzz(15)
    );
  }
}