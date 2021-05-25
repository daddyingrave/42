package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.ArrayList;
import java.util.Stack;

public class MinimumRemovalsValidString {
  public String makeStringValid(String s) {
    var openParenthesis = new Stack<Integer>();
    var indexesToRemove = new ArrayList<Integer>();

    var sb2 = new StringBuilder(s);

    for (int i = 0; i < s.length(); i++) {
      var curChar = s.charAt(i);
      if (curChar == '(') {
        openParenthesis.push(i);
      } else if (curChar == ')') {
        if (!openParenthesis.isEmpty()) {
          openParenthesis.pop();
        } else {
          sb2.replace(i, i + 1, " ");
        }
      }
    }
    while (!openParenthesis.isEmpty()) {
      var index = openParenthesis.pop();
      sb2.deleteCharAt(index);
    }

    return sb2.toString().replaceAll(" ", "");
  }
}
