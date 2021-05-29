package com.github.andreyelagin.backtobackswe.tree;

public class BSTLowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, int x, int y) {
    if (root != null && root.val > x && root.val > y) {
      return lowestCommonAncestor(root.left, x, y);
    } else if (root != null && root.val < x && root.val < y) {
      return lowestCommonAncestor(root.right, x, y);
    }
    return root;
  }
}
