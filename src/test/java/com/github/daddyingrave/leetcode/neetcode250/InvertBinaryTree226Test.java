package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvertBinaryTree226Test {
  class Solution {
    public TreeNode invertTree(TreeNode root) {
      invert(root);
      return root;
    }

    void invert(TreeNode node) {
      if (node == null) {
        return;
      }

      var tmp = node.left;
      node.left = node.right;
      node.right = tmp;

      invert(node.left);
      invert(node.right);
    }
  }

  @Test
  void test() {
    System.out.println(new Solution().invertTree(TreeNode.TreeNodeDefault()));
  }
}
