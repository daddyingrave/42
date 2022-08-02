package com.github.daddyingrave.backtobackswe.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateThePowerset {
  public List<List<Integer>> powerset(int[] inputSet) {
    var result = new ArrayList<List<Integer>>();
    set(0, inputSet, new ArrayList<>(), result);
    return result;
  }

  private void set(
      int currentIndex,
      int[] input,
      List<Integer> partialSet,
      List<List<Integer>> result) {
    if (currentIndex == input.length) {
      result.add(new ArrayList<>(partialSet));
      return;
    }

    partialSet.add(input[currentIndex]);

    set(currentIndex + 1, input, partialSet, result);
    partialSet.remove(partialSet.size() - 1);
    set(currentIndex + 1, input, partialSet, result);
  }
}
