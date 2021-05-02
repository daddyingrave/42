package com.github.andreyelagin.backtobackswe.arrays;

import java.util.*;

public class The3Sum {
  public List<List<Integer>> threeSum(int[] A) {
    Arrays.sort(A);
    Set<List<Integer>> res = new HashSet<>();
    
    for (int i = 0; i < A.length; i++) {
      findTwoSums(i, A, res);
    }
    
    return new ArrayList<>(res);
  }
  
  private void findTwoSums(int rootIndex, int[] a, Set<List<Integer>> res) {
    int left = rootIndex + 1;
    int right = a.length - 1;
    
    while (left < right) {
      int sum = a[left] + a[right] + a[rootIndex];
      if (sum == 0) {
        res.add(List.of(a[rootIndex], a[left++], a[right--]));
      } else if (sum < 0) {
        left++;
      } else {
        right--;
      }
    }
  }
}
