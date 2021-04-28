package com.github.andreyelagin.backtobackswe.primitives;

public class ReverseBits {
  public static int reverseBits(int input) {
    int out = 0;
    while (input != 0) {
      out = out << 1;
      System.out.println(Integer.toBinaryString(out));
      if ((input & 1) == 1)
        out = out | 1;
      input = input >> 1;
    }
    
    return out;
  }
}
