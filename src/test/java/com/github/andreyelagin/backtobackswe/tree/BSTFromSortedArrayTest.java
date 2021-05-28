package com.github.andreyelagin.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTFromSortedArrayTest {

  BSTFromSortedArray bstBuilder = new BSTFromSortedArray();

  @Test
  void sortedArrayToBST() {
    var root = new TreeNode(4);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(6);
    var node4 = new TreeNode(1);
    var node5 = new TreeNode(3);
    var node6 = new TreeNode(5);
    var node7 = new TreeNode(7);

    root.left = node2;
    root.right = node3;

    node2.left = node4;
    node2.right = node5;

    node3.left = node6;
    node3.right = node7;

    assertEquals(root, bstBuilder.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7}));
  }
}