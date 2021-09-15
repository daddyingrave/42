package com.github.andreyelagin.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

  private static final Map<Character, String[]> phoneDigits = new HashMap<>();

  static {
    phoneDigits.put('2', new String[]{"a", "b", "c"});
    phoneDigits.put('3', new String[]{"d", "e", "f"});
    phoneDigits.put('4', new String[]{"g", "h", "i"});
    phoneDigits.put('5', new String[]{"j", "k", "l"});
    phoneDigits.put('6', new String[]{"m", "n", "o"});
    phoneDigits.put('7', new String[]{"p", "q", "r", "s"});
    phoneDigits.put('8', new String[]{"t", "u", "v"});
    phoneDigits.put('9', new String[]{"w", "x", "y", "z"});
  }

  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.isEmpty()) {
      return List.of();
    }
    
    var result = new ArrayList<String>();

    backtrack(0, new StringBuilder(), digits, result);

    return result;
  }

  private void backtrack(
      int index,
      StringBuilder sb,
      String digits,
      List<String> result) {
    if (index == digits.length()) {
      result.add(sb.toString());
      return;
    }
    
    var letters = phoneDigits.get(digits.charAt(index));
    
    for (String c : letters) {
      sb.append(c);
      backtrack(index + 1, sb, digits, result);
      sb.delete(sb.length() - 1, sb.length());
    }
  }
}
