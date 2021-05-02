package com.github.andreyelagin.backtobackswe.arrays;

import java.util.ArrayList;
import java.util.List;

public class AllPrimesToN {
  public List<Integer> enumeratePrimes(int n) {
    boolean[] primeChecker = new boolean[n];
    for (int i = 2; i < n; i++) {
      primeChecker[i] = true;
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i < n; i++) {
      int j = i + i;
      if (primeChecker[i]) {
        while (j < n) {
          primeChecker[j] = false;
          j += i;
        }
        primes.add(i);
      }
    }
    return primes;
  }
}
