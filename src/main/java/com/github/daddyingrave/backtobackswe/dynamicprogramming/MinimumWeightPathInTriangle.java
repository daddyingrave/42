package com.github.daddyingrave.backtobackswe.dynamicprogramming;

import java.util.List;

public class MinimumWeightPathInTriangle {
  public int minimumPathCost(List<List<Integer>> triangle) {
    var bottom = triangle.get(triangle.size() - 1);
    int[] state = new int[bottom.size()];

    for (int i = 0; i < bottom.size(); i++) {
      state[i] = bottom.get(i);
    }

    for (int i = triangle.size() - 2; i >= 0; i--) {
      var cur = triangle.get(i);
      for (int j = 0; j < cur.size(); j++) {
        state[j] = Math.min(cur.get(j) + state[j], cur.get(j) + state[j + 1]);
      }
    }

    return state[0];
  }
}
