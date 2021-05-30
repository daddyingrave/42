package com.github.andreyelagin.backtobackswe.tree;

public class BinaryTreeDiameter {
  public int diameterOfBinaryTree(TreeNode root) {
    return findDiameter(root)[0];
  }

  private int[] findDiameter(TreeNode node) {
    if (node == null) {
      return new int[]{0, 0};
    }
    var left = findDiameter(node.left);
    var right = findDiameter(node.right);

    var maxDiameter = Math.max(left[0], right[0]);
    var bestDiameter = Math.max(maxDiameter, left[1] + right[1]);
    var height = Math.max(left[1], right[1]) + 1;
    return new int[]{bestDiameter, height};
  }
}
