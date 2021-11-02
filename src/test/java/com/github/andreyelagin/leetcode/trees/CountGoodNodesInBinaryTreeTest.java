package com.github.andreyelagin.leetcode.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountGoodNodesInBinaryTreeTest {

  CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();
  
  @Test
  void goodNodes() {
    var root = new TreeNode(3);
    var node1 = new TreeNode(1);
    var node2 = new TreeNode(3);
    var node3 = new TreeNode(4);
    var node4 = new TreeNode(1);
    var node5 = new TreeNode(5);
    
    root.left = node1;
    root.right = node3;
    node1.left = node2;
    node3.left = node4;
    node3.right = node5;
    
    assertEquals(4, solution.goodNodes(root));
  }
}