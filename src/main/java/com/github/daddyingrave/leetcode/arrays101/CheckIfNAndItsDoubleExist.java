package com.github.daddyingrave.leetcode.arrays101;

import java.util.HashMap;

public class CheckIfNAndItsDoubleExist {
  public boolean checkIfExist(int[] arr) {
    var map = new HashMap<Integer, Integer>();

    for (int i = 0; i < arr.length; i++) {
      Integer candidateProduct = map.get(arr[i] * 2);
      Integer candidateDivision = map.get(arr[i] / 2);

      if (candidateProduct != null && candidateProduct < i) {
        return true;
      } else if (arr[i] % 2 == 0 && candidateDivision != null && candidateDivision < i) {
        return true;
      } else {
        map.put(arr[i], i);
      }
    }

    return false;
  }
}
