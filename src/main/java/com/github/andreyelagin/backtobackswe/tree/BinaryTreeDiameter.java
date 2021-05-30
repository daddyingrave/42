package com.github.andreyelagin.backtobackswe.tree;

public class BinaryTreeDiameter {
  public int diameterOfBinaryTree(TreeNode root) {
    return findDiameter(root).diameter;
  }

  private CurrentDiameter findDiameter(TreeNode node) {
    if (node == null) {
      return new CurrentDiameter(0, 0);
    }
    var left = findDiameter(node.left);
    var right = findDiameter(node.right);

    var maxDiameter = Math.max(left.diameter, right.diameter);
    var bestDiameter = Math.max(maxDiameter, left.height + right.height);
    var height = Math.max(left.height, right.height) + 1;
    return new CurrentDiameter(bestDiameter, height);
  }

  private static class CurrentDiameter {
    public int diameter;
    public int height;

    public CurrentDiameter(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }
}
