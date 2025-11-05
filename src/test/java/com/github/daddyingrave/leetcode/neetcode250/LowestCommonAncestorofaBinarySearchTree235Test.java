package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LowestCommonAncestorofaBinarySearchTree235Test {
  class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      int rVal = root.val;
      int pVal = p.val;
      int qVal = q.val;

      if (rVal == pVal || rVal == qVal) {
        return root;
      } else if (pVal < rVal && qVal < rVal) {
        return lowestCommonAncestor(root.left, p, q);
      } else if (pVal > rVal && qVal > rVal) {
        return lowestCommonAncestor(root.right, p, q);
      }

      return root;
    }
  }

  @Test
  void test() {

  }
}
