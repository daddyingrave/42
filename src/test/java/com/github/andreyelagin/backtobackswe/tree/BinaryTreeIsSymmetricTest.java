package com.github.andreyelagin.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeIsSymmetricTest {

  BinaryTreeIsSymmetric treeIsSymmetric = new BinaryTreeIsSymmetric();
  
  @Test
  void isSymmetric() {
    var root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    assertTrue(treeIsSymmetric.isSymmetric(root));
  }

  @Test
  void isSymmetric2() {
    var root = new TreeNode(4);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(2);
    var node4 = new TreeNode(1);
    var node5 = new TreeNode(2);
    var node6 = new TreeNode(2);
    
    root.left = node2;
    root.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.left = node6;
    
    assertFalse(treeIsSymmetric.isSymmetric(root));
  }
  
  @Test
  void isSymmetric3() {
    assertTrue(treeIsSymmetric.isSymmetric(new TreeNode(4)));
    assertTrue(treeIsSymmetric.isSymmetric(null));
  }
}