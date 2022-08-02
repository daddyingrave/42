package com.github.daddyingrave.leetcode.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeInorderTraversalTest {

  BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
  
  @Test
  void inorderTraversal() {
    var n1 = new TreeNode(1);
    n1.right = new TreeNode(2);
    n1.right.left = new TreeNode(3);

    assertEquals(
        List.of(1, 3, 2),
        solution.inorderTraversalIterative(n1)
    );
    assertEquals(
        List.of(),
        solution.inorderTraversalIterative(null)
    );
    assertEquals(
        List.of(1),
        solution.inorderTraversalIterative(new TreeNode(1))
    );
    
  }
}