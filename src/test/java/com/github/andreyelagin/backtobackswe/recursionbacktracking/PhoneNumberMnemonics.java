package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberMnemonics {

  private static Map<Character, String> digitsToLetters = new HashMap<>();
  
  static {
    digitsToLetters.put('2', "abc");
    digitsToLetters.put('3', "def");
    digitsToLetters.put('4', "ghi");
    digitsToLetters.put('5', "jkl");
    digitsToLetters.put('6', "mno");
    digitsToLetters.put('7', "pqrs");
    digitsToLetters.put('8', "tuv");
    digitsToLetters.put('9', "wxyz");
  }
  
  public List<String> letterCombinations(String digits) {
    var result = new ArrayList<String>();

    combinations(0, new StringBuilder(), digits, result);
    
    return result;
  }

  private void combinations(
      int digit, 
      StringBuilder partial, 
      String digits, 
      List<String> result
  ) {
    if (digit == digits.length()) {
      result.add(partial.toString());
      return;
    }

    var letters = digitsToLetters.get(digits.charAt(digit));

    for (char letter : letters.toCharArray()) {
      partial.append(letter);
      combinations(digit + 1, partial, digits, result);
      partial.deleteCharAt(partial.length() - 1);
    }
  }
}
