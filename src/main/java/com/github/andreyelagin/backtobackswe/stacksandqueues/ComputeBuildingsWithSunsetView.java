package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.ArrayList;
import java.util.List;

public class ComputeBuildingsWithSunsetView {
  public List<Integer> getBuildingsWithAView(int[] buildings) {
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
