package com.github.andreyelagin.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTLowestCommonAncestorTest {

  BSTLowestCommonAncestor ancestor = new BSTLowestCommonAncestor();

  @Test
  void lowestCommonAncestor() {
    var root = new TreeNode(50);
    var node2 = new TreeNode(25);
    var node3 = new TreeNode(100);
    var node4 = new TreeNode(1);
    var node5 = new TreeNode(27);
    var node6 = new TreeNode(80);
    var node7 = new TreeNode(101);

    root.left = node2;
    root.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    assertEquals(50, ancestor.lowestCommonAncestor(root, 1, 102).val);
    assertEquals(25, ancestor.lowestCommonAncestor(root, 1, 27).val);
  }
}