package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicDecompositions {
  public List<List<String>> partition(String s) {
    var result = new ArrayList<List<String>>();

    palindromic(0, s, new ArrayList<>(), result);
    
    return result;
  }

  private void palindromic(int index, String s, List<String> partial, List<List<String>> result) {
    if (index == s.length()) {
      result.add(new ArrayList<>(partial));
      return;
    }

    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(index, i, s)) {
        var snippet = s.substring(index, i + 1);
        partial.add(snippet);

        palindromic(i + 1, s, partial, result);

        partial.remove(partial.size() - 1);
      }
    }
  }

  private boolean isPalindrome(int left, int right, String s) {
    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }
}
