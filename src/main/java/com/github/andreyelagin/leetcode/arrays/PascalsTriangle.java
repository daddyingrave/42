package com.github.andreyelagin.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
  public List<List<Integer>> generate(int numRows) {
    var result = new ArrayList<List<Integer>>();

    var prev = new ArrayList<Integer>();
    prev.add(1);
    result.add(prev);

    for (int i = 1; i < numRows; i++) {
      var cur = new ArrayList<Integer>();
      cur.add(1);
      for (int j = 1; j < i; j++) {
        int curNum = 0;
        curNum += prev.get(j - 1);
        curNum += prev.get(j);
        cur.add(curNum);
      }
      cur.add(1);
      result.add(cur);
      prev = cur;
    }
    
    return result;
  }
}
