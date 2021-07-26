package com.github.andreyelagin.backtobackswe.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {
  public List<Integer> findDuplicates(int[] nums) {
    var result = new ArrayList<Integer>();
    
    int[] count = new int[nums.length + 1];
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]]++;
    }

    for (int i = 0; i < count.length; i++) {
      if (count[i] == 2) {
        result.add(i);
      }
    }
    
    return result;
  }
}
