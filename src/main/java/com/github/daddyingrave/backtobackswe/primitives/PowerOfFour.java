package com.github.daddyingrave.backtobackswe.primitives;

public class PowerOfFour {
  public static boolean powerOfFour(int input) {
    int mask = 0x55555555;
    
    return input != 0 && (((input - 1) & input) == 0) && (input & mask) == input;
  }
}
