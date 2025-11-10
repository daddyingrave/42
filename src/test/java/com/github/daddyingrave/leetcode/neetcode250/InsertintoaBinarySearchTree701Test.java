package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InsertintoaBinarySearchTree701Test {
  class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if (root == null) {
        return new TreeNode(val);
      }

      if (val < root.val) {
        root.left = insertIntoBST(root.left, val);
      } else {
        root.right = insertIntoBST(root.right, val);
      }

      return root;
    }
  }

  @Test
  void test() {

  }
}
