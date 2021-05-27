package com.github.andreyelagin.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTPropertyTest {

  BSTProperty bstProperty = new BSTProperty();
  
  @Test
  void isValidBST() {
    var root = new TreeNode(2);
    var node2 = new TreeNode(1);
    var node3 = new TreeNode(4);
    var node4 = new TreeNode(3);
    var node5 = new TreeNode(5);
    root.left = node2;
    root.right = node3;
    node3.left = node4;
    node3.right = node5;
    
    assertTrue(bstProperty.isValidBST(root));
  }

  @Test
  void isValidBST2() {
    var root = new TreeNode(10);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(7);
    var node4 = new TreeNode(3);
    var node5 = new TreeNode(12);
    root.left = node2;
    root.right = node3;
    node3.left = node4;
    node3.right = node5;

    assertFalse(bstProperty.isValidBST(root));
  }

  @Test
  void isValidBST3() {
    var root = new TreeNode(3);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(7);
    var node4 = new TreeNode(1);
    var node5 = new TreeNode(5);
    var node6 = new TreeNode(6);
    var node7 = new TreeNode(8);
    
    root.left = node2;
    root.right = node3;
    
    node2.left = node4;
    node2.right = node5;
    
    node3.left = node6;
    node3.right = node7;

    assertFalse(bstProperty.isValidBST(root));
  }
}