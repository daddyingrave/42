package com.github.andreyelagin.backtobackswe.tree;

public class SumRootToLeafPaths {
  public boolean hasPathSum(TreeNode node, int targetSum) {
    return sumTraverse(node, 0, targetSum);
  }

  private boolean sumTraverse(TreeNode node, int currentSum, int targetSum) {
    if (node == null) {
      return false;
    }
    var newSum = currentSum + node.val;
    if (targetSum == newSum && node.left == null && node.right == null) {
      return true;
    }
    if (newSum > targetSum) {
      return false;
    }

    return sumTraverse(node.left, newSum, targetSum) || sumTraverse(node.right, newSum, targetSum);
  }
}
