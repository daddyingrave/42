package com.github.andreyelagin.leetcode.design;

import com.github.andreyelagin.leetcode.trees.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializeAndDeserializeBinaryTreeTest {

  SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();
  
  @Test
  void serializeAndDeserializeTest() {
    var n1 = new TreeNode(1);
    n1.left = new TreeNode(2);
    n1.left.left = new TreeNode(-3);
    n1.right = new TreeNode(3);
    n1.right.left = new TreeNode(4);
    n1.right.right = new TreeNode(5);
    
    System.out.println(solution.serialize(n1));
  }
}