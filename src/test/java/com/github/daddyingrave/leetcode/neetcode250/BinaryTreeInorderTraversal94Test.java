package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeInorderTraversal94Test {
  class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
      var result = new ArrayList<Integer>();
      traverse(root, result);
      return result;
    }

    void traverse(TreeNode node, List<Integer> traversal) {
      if (node == null) {
        return;
      }

      traverse(node.left, traversal);
      traversal.add(node.val);
      traverse(node.right, traversal);
    }
  }

  @Test
  void test() {

  }
}
