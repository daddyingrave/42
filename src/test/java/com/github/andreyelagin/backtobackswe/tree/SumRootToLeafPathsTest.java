package com.github.andreyelagin.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumRootToLeafPathsTest {

  SumRootToLeafPaths sum = new SumRootToLeafPaths();
  
  @Test
  void hasPathSum() {
    var root = new TreeNode(1);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(2);
    var node4 = new TreeNode(5);
    root.right = node2;
    node2.left = node3;
    node2.right = node4;

    assertTrue(sum.hasPathSum(root, 5));
  }

  @Test
  void hasPathSum2() {
    var root = new TreeNode(5);
    var node2 = new TreeNode(5);
    var node3 = new TreeNode(1);
    var node4 = new TreeNode(-1);
    root.left = node2;
    node2.left = node3;
    node2.right = node4;

    assertFalse(sum.hasPathSum(root, 10));
  }
}