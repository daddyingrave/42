package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105Test {

  int prePtr = 0;
  int inPtr = 0;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return bfs(preorder, inorder, Integer.MAX_VALUE);
  }

  TreeNode bfs(int[] preorder, int[] inorder, int limit) {
    if (prePtr >= preorder.length) {
      return null;
    }
    if (inorder[inPtr] == limit) {
      inPtr++;
      return null;
    }

    var root = new TreeNode(preorder[prePtr++]);
    root.left = bfs(preorder, inorder, root.val);
    root.right = bfs(preorder, inorder, limit);

    return root;
  }

  @Test
  void test() {
    var root = new TreeNode(3);
    var left = new TreeNode(9);
    var right = new TreeNode(20);
    var rightLeft = new TreeNode(15);
    var rightRight = new TreeNode(7);

    root.left = left;
    root.right = right;
    right.left = rightLeft;
    right.right = rightRight;

    buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
  }
}
