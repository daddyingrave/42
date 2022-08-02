package com.github.daddyingrave.leetcode.trees;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    var result = new ArrayList<List<Integer>>();

    boolean direction = true;
    Stack<TreeNode> deckLeft = new Stack<TreeNode>();
    Stack<TreeNode> deckRight = new Stack<TreeNode>();

    if (root != null) {
      deckLeft.push(root);
    }

    while (!deckLeft.isEmpty() || !deckRight.isEmpty()) {
      var currentLevelResult = new ArrayList<Integer>();
      if (!deckLeft.isEmpty()) {
        while (!deckLeft.isEmpty()) {
          var node = deckLeft.pop();
          currentLevelResult.add(node.val);
          if (node.left != null) {
            deckRight.push(node.left);
          }
          if (node.right != null) {
            deckRight.push(node.right);
          }
        }
      } else {
        while (!deckRight.isEmpty()) {
          var node = deckRight.pop();
          currentLevelResult.add(node.val);
          if (node.right != null) {
            deckLeft.push(node.right);
          }
          if (node.left != null) {
            deckLeft.push(node.left);
          }
        }
      }
      result.add(currentLevelResult);
    }

    return result;
  }
}
