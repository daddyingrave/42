package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MinimumRemovalsValidString {
  public String makeStringValid(String s) {
    var openParenthesis = new Stack<Integer>();
    var indexesToRemove = new ArrayList<Integer>();

    for (int i = 0; i < s.length(); i++) {
      var curChar = s.charAt(i);
      if (curChar == '(') {
        openParenthesis.push(i);
      } else if (curChar == ')') {
        if (!openParenthesis.isEmpty()) {
          openParenthesis.pop();
        } else {
          indexesToRemove.add(i);
        }
      }
    }
    while (!openParenthesis.isEmpty()) {
      indexesToRemove.add(openParenthesis.pop());
    }

    Collections.sort(indexesToRemove);
    var arr = s.toCharArray();

    for (Integer index : indexesToRemove) {
      arr[index] = '*';
    }

    var sb = new StringBuilder();
    for (char c : arr) {
      if (c != '*') {
        sb.append(c);
      }
    }
    
    return sb.toString();
  }
}
