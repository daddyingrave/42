package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateBinarySearchTree98Test {
  class Solution {
    public boolean isValidBST(TreeNode root) {
      return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean valid(TreeNode node, long left, long right) {
      if (node == null) {
        return true;
      }

      if (!(left < node.val && node.val < right)) {
        return false;
      }

      return valid(node.left, left, node.val) && valid(node.right, node.val, right);
    }
  }

  @Test
  void test() {

  }
}
