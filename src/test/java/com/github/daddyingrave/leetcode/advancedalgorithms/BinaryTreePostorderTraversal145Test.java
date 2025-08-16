package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal145Test {
  class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      var result = new ArrayList<Integer>();
      if (root == null) {
        return result;
      }

      record Pair(TreeNode node, boolean visited) {
      }

      var stack = new Stack<Pair>();
      stack.push(new Pair(root, false));

      while (!stack.isEmpty()) {
        var cur = stack.pop();
        if (cur.visited) {
          result.add(cur.node.val);
        } else {
          stack.push(new Pair(cur.node, true));
          if (cur.node.right != null) {
            stack.push(new Pair(cur.node.right, false));
          }
          if (cur.node.left != null) {
            stack.push(new Pair(cur.node.left, false));
          }
        }
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
