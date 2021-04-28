package com.github.andreyelagin.backtobackswe.primitives;

public class PowerOfTwo {
  public static boolean powerOfTwo(int input) {
    return input > 0 && ((input & (input - 1)) == 0);
  }

  public static boolean myStupidSolution(int input) {
    if (input == 1) return true;
    if (input < 2) return false;

    while (input > 1) {
      if ((input & 1) == 1) return false;
      input = input >> 1;
    }

    return true;
  }
}
