package com.github.andreyelagin.backtobackswe.dynamicprogramming;

import java.util.Arrays;

public class ArrayProduct {
  public int[] productExceptCurrentElement(int[] arr) {
    int[] prefix = new int[arr.length];
    int[] suffix = new int[arr.length];

    prefix[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      prefix[i] = prefix[i - 1] * arr[i];
    }

    suffix[suffix.length - 1] = arr[arr.length - 1];
    for (int i = suffix.length - 2; i >= 0; i--) {
      suffix[i] = suffix[i + 1] * arr[i];
    }

    int[] result = new int[arr.length];
    Arrays.fill(result, 1);

    for (int i = 0; i < arr.length; i++) {
      if (i != 0) {
        result[i] *= prefix[i - 1];
      }
      if (i != arr.length - 1) {
        result[i] *= suffix[i + 1];
      }
    }
    
    return result;
  }
}
