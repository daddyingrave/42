package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class SubtreeofAnotherTree572Test {
  class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      if (root == null && subRoot == null) {
        return true;
      }
      if (root == null || subRoot == null) {
        return false;
      }

      if (root.val == subRoot.val && isSame(root, subRoot)) {
        return true;
      }

      return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean isSame(TreeNode tree1, TreeNode tree2) {
      if (tree1 == null && tree2 == null) {
        return true;
      }

      if ((tree1 == null || tree2 == null) || tree1.val != tree2.val) {
        return false;
      }

      return isSame(tree1.left, tree2.left) && isSame(tree1.right, tree2.right);
    }
  }

  @Test
  void test() {

  }
}
