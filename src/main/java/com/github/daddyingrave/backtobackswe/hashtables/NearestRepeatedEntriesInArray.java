package com.github.daddyingrave.backtobackswe.hashtables;

import java.util.HashMap;

public class NearestRepeatedEntriesInArray {
  public int distanceOfClosestRepeatedEntries(String[] sentence) {
    var items = new HashMap<String, Integer>();
    var distance = -1;

    for (int i = 0; i < sentence.length; i++) {
      var previousIndex = items.put(sentence[i], i);
      if (previousIndex != null) {
        int newDistance = i - previousIndex;
        if (distance == -1) {
          distance = newDistance;
        } else {
          distance = Math.min(distance, newDistance);
        }
      }
    }

    return distance;
  }
}
