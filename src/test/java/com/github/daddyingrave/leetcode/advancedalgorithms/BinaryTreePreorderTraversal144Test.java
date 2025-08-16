package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreePreorderTraversal144Test {
  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      var result = new ArrayList<Integer>();

      var stack = new Stack<TreeNode>();
      var cur = root;
      while (cur != null || !stack.isEmpty()) {
        if (cur != null) {
          result.add(cur.val);
          if (cur.right != null) {
            stack.push(cur.right);
          }

          cur = cur.left;
        } else {
          cur = stack.pop();
        }
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
