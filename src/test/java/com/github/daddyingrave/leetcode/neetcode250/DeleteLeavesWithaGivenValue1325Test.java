package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteLeavesWithaGivenValue1325Test {
  class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
      if (root == null) {
        return null;
      }

      root.left = removeLeafNodes(root.left, target);
      root.right = removeLeafNodes(root.right, target);

      if (root.right == null && root.left == null && root.val == target) {
        return null;
      } else {
        return root;
      }
    }
  }

  @Test
  void test() {

  }
}
