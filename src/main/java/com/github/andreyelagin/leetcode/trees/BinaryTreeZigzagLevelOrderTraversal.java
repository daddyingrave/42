package com.github.andreyelagin.leetcode.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    var result = new ArrayList<List<Integer>>();

    boolean direction = true;
    Deque<TreeNode> deckLeft = new LinkedList<TreeNode>();
    Deque<TreeNode> deckRight = new LinkedList<TreeNode>();

    if (root != null) {
      deckLeft.push(root);
    }
    // [3,9,20,null,null,15,7]
    // [1,2,3,4,null,null,5]
    while (!deckLeft.isEmpty() || !deckRight.isEmpty()) {
      var currentLevelResult = new ArrayList<Integer>();
      if (!deckLeft.isEmpty()) {
        while (!deckLeft.isEmpty()) {
          var node = deckLeft.removeFirst();
          currentLevelResult.add(node.val);
          if (node.left != null) {
            deckRight.addFirst(node.left);
          }
          if (node.right != null) {
            deckRight.addFirst(node.right);
          }
        }
      } else {
        while (!deckRight.isEmpty()) {
          var node = deckRight.removeFirst();
          currentLevelResult.add(node.val);
          if (node.right != null) {
            deckLeft.addFirst(node.right);
          }
          if (node.left != null) {
            deckLeft.addFirst(node.left);
          }
        }
      }
      result.add(currentLevelResult);
    }

    return result;
  }
}
