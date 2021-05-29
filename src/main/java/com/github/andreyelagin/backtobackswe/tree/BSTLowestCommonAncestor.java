package com.github.andreyelagin.backtobackswe.tree;

public class BSTLowestCommonAncestor {
  public TreeNode lowestCommonAncestor(TreeNode root, int x, int y) {
    return findCommonAncestor(root, x, y);
  }

  private TreeNode findCommonAncestor(TreeNode root, int x, int y) {
    if (root != null && ((root.val < x && root.val > y) || (root.val > x && root.val < y))) {
      return root;
    } else if (root != null && root.val > x) {
      return findCommonAncestor(root.left, x, y);
    } else if (root != null && root.val < x) {
      return findCommonAncestor(root.right, x, y);
    }
    return root;
  }
}
