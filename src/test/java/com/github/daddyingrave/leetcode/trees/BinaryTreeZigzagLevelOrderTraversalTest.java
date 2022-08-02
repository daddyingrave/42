package com.github.daddyingrave.leetcode.trees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeZigzagLevelOrderTraversalTest {

  BinaryTreeZigzagLevelOrderTraversal solution = new BinaryTreeZigzagLevelOrderTraversal();
  
  @Test
  void zigzagLevelOrder() {
    var n1 = new TreeNode(1);
    n1.left = new TreeNode(2);
    n1.left.left = new TreeNode(4);
    n1.right = new TreeNode(3);
    n1.right.right = new TreeNode(5);

    assertEquals(
        List.of(List.of(1), List.of(3, 2), List.of(4, 5)),
        solution.zigzagLevelOrder(n1)
    );
  }
  
  @Test
  void zigzagLevelOrder2() {
    var n1 = new TreeNode(3);
    n1.left = new TreeNode(9);
    n1.right = new TreeNode(20);
    n1.right.left = new TreeNode(15);
    n1.right.right = new TreeNode(7);

    assertEquals(
        List.of(List.of(3), List.of(20, 9), List.of(15, 7)),
        solution.zigzagLevelOrder(n1)
    );
  }
}