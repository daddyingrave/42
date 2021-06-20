package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public List<List<Integer>> permute(int[] originalArray) {
    var result = new ArrayList<List<Integer>>();

    backtrack(originalArray, new ArrayList<>(), result);
    
    return result;
  }

  private void backtrack(
      int[] origin,
      List<Integer> choices,
      List<List<Integer>> result) {
    if (choices.size() == origin.length) {
      result.add(new ArrayList<>(choices));
      return;
    }

    for (int i = 0; i < origin.length; i++) {
      int currentChoice = origin[i];
      if (choices.contains(currentChoice)) {
        continue;
      }

      choices.add(currentChoice);
      
      backtrack(origin, choices, result);

      choices.remove(choices.size() - 1);
    }
  }
}
