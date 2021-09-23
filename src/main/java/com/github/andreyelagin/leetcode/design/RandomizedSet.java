package com.github.andreyelagin.leetcode.design;

import java.util.*;

public class RandomizedSet {

  Random random = new Random();
  List<Integer> keys = new ArrayList<>();
  Map<Integer, Integer> locations = new HashMap<>();

  public RandomizedSet() {
  }

  public boolean insert(int val) {
    var location = locations.get(val);
    if (location != null) {
      return false;
    }
    locations.put(val, keys.size());
    keys.add(val);
    return true;
  }

  public boolean remove(int val) {
    var location = locations.get(val);
    if (location == null) {
      return false;
    }
    if (location < keys.size() - 1) {
      int last = keys.get(keys.size() - 1);
      keys.set(location, last);
      locations.put(last, location);
    }
    locations.remove(val);
    keys.remove(keys.size() - 1);
    
    return true;
  }

  public int getRandom() {
    return keys.get(random.nextInt(keys.size()));
  }
}
