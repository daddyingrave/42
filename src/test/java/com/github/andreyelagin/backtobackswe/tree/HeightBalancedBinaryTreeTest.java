package com.github.andreyelagin.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightBalancedBinaryTreeTest {

  HeightBalancedBinaryTree balancedBinaryTree = new HeightBalancedBinaryTree();
  
  @Test
  void isBalanced() {
    var root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    
    assertTrue(balancedBinaryTree.isBalanced(root));
  }

  @Test
  void isBalanced2() {
    var root = new TreeNode(2);
    root.left = new TreeNode(1);
    TreeNode node1 = new TreeNode(1);
    root.right = node1;
    TreeNode node2 = new TreeNode(666);
    node1.right = node2;
    node2.right = new TreeNode(777);

    assertFalse(balancedBinaryTree.isBalanced(root));
  }
}