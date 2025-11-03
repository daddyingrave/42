package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SameTree100Test {
  class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      if (p == null && q == null) {
        return true;
      }

      if ((p == null || q == null) || p.val != q.val) {
        return false;
      }

      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  }

  @Test
  void test() {

  }
}
