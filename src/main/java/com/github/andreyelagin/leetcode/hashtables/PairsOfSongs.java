package com.github.andreyelagin.leetcode.hashtables;

public class PairsOfSongs {
  public int numPairsDivisibleBy60(int[] time) {
    int[] modules = new int[60];
    for (int j : time) {
      modules[j % 60]++;
    }

    int count = 0;
    for (int i = 0; i < time.length; i++) {
      int curModulo = time[i] % 60;
      modules[curModulo]--;
      int moduloIndex = curModulo == 0 ? 0 : 60 - curModulo;
      if (modules[moduloIndex] > 0) {
        count += modules[moduloIndex];
      }
      
    }

    return count;
  }
}
