package com.github.daddyingrave.backtobackswe.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyBinaryTreeTest {

  ModifyBinaryTree modifyBinaryTree = new ModifyBinaryTree();
  
  private static TreeNode expectedInsert = null;
  private static TreeNode expectedDelete = null;
  
  @BeforeAll
  static void before() {
    var root = new TreeNode(4);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(6);

    root.left = node2;
    root.right = node3;

    node3.right = new TreeNode(8);
    expectedInsert = root;
  }
  
  @Test
  void insert() {
    var root = new TreeNode(4);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(6);

    root.left = node2;
    root.right = node3;

    assertEquals(expectedInsert, modifyBinaryTree.insert(root, 8));
  }

  @Test
  void delete() {
    var root = new TreeNode(4);
    var node2 = new TreeNode(2);
    var node3 = new TreeNode(6);

    root.left = node2;
    root.right = node3;

    node3.right = new TreeNode(8);
    
    var expectedRoot = new TreeNode(4);
    var deleteNode2 = new TreeNode(2);
    var deleteNode3 = new TreeNode(6);

    expectedRoot.left = deleteNode2;
    expectedRoot.right = deleteNode3;
    
    assertEquals(expectedRoot, modifyBinaryTree.delete(root, 8));
  }
}