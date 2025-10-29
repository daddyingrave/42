package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreePreorderTraversal144Test {
  class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
      var stack = new Stack<TreeNode>();
      var cur = root;
      var result = new ArrayList<Integer>();

      while (cur != null || !stack.isEmpty()) {
        if (cur == null) {
          cur = stack.pop();
        }

        result.add(cur.val);
        if (cur.right != null) {
          stack.push(cur.right);
        }

        cur = cur.left;
      }

      return result;
    }
  }

  @Test
  void test() {
    System.out.println(new Solution().preorderTraversal(TreeNode.TreeNodeDefault()));
  }
}
