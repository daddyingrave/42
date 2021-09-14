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
    var result = new ArrayList<String>();

    backtrack(0, 0, new StringBuilder(), digits, result);

    return result;
  }

  private void backtrack(
      int curDigitIndex,
      int curLetterIndex,
      int nextDigitIndex,
      int nextLetterIndex,
      StringBuilder sb,
      String digits,
      List<String> result) {
    if (curDigitIndex >= digits.length() - 1) {
      return;
    } else if (nextDigitIndex >= digits.length()) {
      backtrack(curDigitIndex + 1, 0, curDigitIndex + 2, 0, new StringBuilder(), digits, result);
    }
    
    else if (curLetterIndex >= phoneDigits.get(digits.charAt(curLetterIndex)).length) {
      backtrack(curDigitIndex + 1, 0, curDigitIndex + 2, 0, new StringBuilder(), digits, result);
    }
//    else if (nextLetterIndex >= phoneDigits.get(digits.charAt(nextDigitIndex)).length) {
//      // todo
//      result.add(sb.toString());
//      backtrack(nextDigitIndex + 1, 0, new StringBuilder(), digits, result);
//    }

    char curLetter = digits.charAt(nextDigitIndex);
    var curPhoneLetter = phoneDigits.get(curLetter)[nextLetterIndex];
    
    backtrack(nextDigitIndex, nextLetterIndex + 1, sb, digits, result);
  }
}
