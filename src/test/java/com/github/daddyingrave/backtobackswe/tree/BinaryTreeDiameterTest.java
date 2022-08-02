package com.github.daddyingrave.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeDiameterTest {

  BinaryTreeDiameter diameter = new BinaryTreeDiameter();
  
  @Test
  void diameterOfBinaryTree() {
    var root = new TreeNode(1);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(3);
    var node4 = new TreeNode(4);
    var node5 = new TreeNode(5);
    var node6 = new TreeNode(6);
    var node7 = new TreeNode(7);
    var node8 = new TreeNode(8);
    var node9 = new TreeNode(9);
    
    root.left = node2;
    root.right = node3;
    
    node3.left = node4;
    node4.left = node5;
    node5.right = node6;
    
    node3.right = node7;
    node7.left = node8;
    node7.right = node9;
    
    assertEquals(5, diameter.diameterOfBinaryTree(root));
  }
}