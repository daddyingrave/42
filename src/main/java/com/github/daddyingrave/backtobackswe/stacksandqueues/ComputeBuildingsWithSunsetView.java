package com.github.daddyingrave.backtobackswe.stacksandqueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class ComputeBuildingsWithSunsetView {
  public List<Integer> getBuildingsWithAView(int[] buildings) {
    var stack = new Stack<Integer>();
    for (int i = buildings.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && buildings[i] >= buildings[stack.peek()]) {
        stack.pop();
      }
      stack.push(i);
    }

    Collections.reverse(stack);
    
    return new ArrayList<>(stack);
  }

  public List<Integer> getBuildingsWithAViewMy(int[] buildings) {
    var resp = new ArrayList<Integer>();

    int max = buildings[0];
    resp.add(0);

    for (int i = 1; i < buildings.length; i++) {
      if (buildings[i] > max) {
        resp.add(i);
        max = buildings[i];
      }
    }

    return resp;
  }
}
