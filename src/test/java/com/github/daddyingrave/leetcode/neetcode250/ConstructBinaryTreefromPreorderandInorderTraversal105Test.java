package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

public class ConstructBinaryTreefromPreorderandInorderTraversal105Test {
  class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    int preIndex = 0;
    int inIndex = 0;

    TreeNode dfs(int[] preorder, int[] inorder, int limit) {
      if (preIndex >= preorder.length) {
        return null;
      }
      if (inorder[inIndex] == limit) {
        inIndex++;
        return null;
      }

      var root = new TreeNode(preorder[preIndex++]);
      root.left = dfs(preorder, inorder, root.val);
      root.right = dfs(preorder, inorder, limit);

      return root;
    }
  }

  @Test
  void test() {

  }
}
