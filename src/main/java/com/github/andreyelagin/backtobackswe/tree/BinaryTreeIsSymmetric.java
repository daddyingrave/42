package com.github.andreyelagin.backtobackswe.tree;

public class BinaryTreeIsSymmetric {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return checkSymmetry(root.left, root.right);
  }

  private boolean checkSymmetry(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
      return true;
    }
    if (left != null && right != null) {
      return left.val == right.val
          && checkSymmetry(left.left, left.right)
          && checkSymmetry(right.left, right.right);
    }
    
    return false;
  }
}
