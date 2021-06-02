package com.github.andreyelagin.backtobackswe.tree;

public class HeightBalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
    return balanced(root).balanced;
  }

  private BalancedCarry balanced(TreeNode root) {
    if (root == null) {
      return new BalancedCarry(true, -1);
    }

    var leftBalanced = balanced(root.left);
    if (!leftBalanced.balanced) {
      return leftBalanced;
    }

    var rightBalanced = balanced(root.right);
    if (!rightBalanced.balanced) {
      return rightBalanced;
    }

    var balanced = Math.abs(leftBalanced.height - rightBalanced.height) <= 1;
    var height = Math.max(leftBalanced.height, rightBalanced.height) + 1;

    return new BalancedCarry(balanced, height);
  }

  private static class BalancedCarry {
    public boolean balanced;
    public int height;

    public BalancedCarry(boolean balanced, int height) {
      this.balanced = balanced;
      this.height = height;
    }
  }
}
