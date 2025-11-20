package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

public class HouseRobberIII337Test {
  class Solution {
    public int rob(TreeNode root) {
      var pair = dfs(root);
      return Math.max(pair.with, pair.without);
    }

    record Pair(int with, int without) {
    }

    Pair dfs(TreeNode root) {
      if (root == null) {
        return new Pair(0, 0);
      }

      var leftPair = dfs(root.left);
      var rightPair = dfs(root.right);

      int withRoot = root.val + leftPair.without + rightPair.without;
      int withoutRoot = Math.max(leftPair.with, leftPair.without) + Math.max(rightPair.with, rightPair.without);

      return new Pair(withRoot, withoutRoot);
    }
  }

  @Test
  void test() {

  }
}
