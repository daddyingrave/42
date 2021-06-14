package com.github.andreyelagin.backtobackswe.sorting;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class VerifyingCharacterOrdering {
  public boolean verifyOrdering(List<String> A, String ordering) {
    var orderBindings = new HashMap<Character, Integer>();
    for (int i = 0; i < ordering.length(); i++) {
      orderBindings.put(ordering.charAt(i), i);
    }

    Comparator<String> comp = (s1, s2) -> {
      if (s1.equals(s2)) {
        return 0;
      }
      int i = 0;
      while (s1.charAt(i) == s2.charAt(i)) {
        i++;
        if (i >= s1.length() || i >= s2.length()) {
          if (s1.length() > s2.length()) {
            return 1;
          } else {
            return -1;
          }
        }
      }
      if (orderBindings.get(s1.charAt(i)) >= orderBindings.get(s2.charAt(i))) {
        return 1;
      } else {
        return -1;
      }
    };

    for (int i = 1; i < A.size(); i++) {
      if (comp.compare(A.get(i), A.get(i - 1)) < 0) {
        return false;
      }
    }

    return true;
  }
}

