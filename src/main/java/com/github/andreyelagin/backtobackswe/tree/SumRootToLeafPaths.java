package com.github.andreyelagin.backtobackswe.tree;

public class SumRootToLeafPaths {
  public boolean hasPathSum(TreeNode node, int targetSum) {
    if (node == null) {
      return false;
    }
    if (targetSum - node.val == 0 && node.left == null && node.right == null) {
      return true;
    }

    return hasPathSum(node.left, targetSum - node.val)
        || hasPathSum(node.right, targetSum - node.val);
  }

  public boolean hasPathSumMy(TreeNode node, int targetSum) {
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
