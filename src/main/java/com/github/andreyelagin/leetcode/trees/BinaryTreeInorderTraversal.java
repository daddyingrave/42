package com.github.andreyelagin.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    var result = new ArrayList<Integer>();
    traverse(root, result);
    return result;
  }

  private void traverse(TreeNode node, List<Integer> values) {
    if (node == null) {
      return;
    }

    traverse(node.left, values);
    values.add(node.val);
    traverse(node.right, values);
  }

  public List<Integer> inorderTraversalIterative(TreeNode root) {
    var result = new ArrayList<Integer>();

    var stack = new Stack<TreeNode>();
    var cur = root;
    
    while (cur != null || !stack.isEmpty()) {
      if (cur != null) {
        while (cur != null) {
          stack.push(cur);
          cur = cur.left;
        }
      } else {
        var last = stack.pop();
        result.add(last.val);
        if (last.right != null) {
          cur = last.right;
        }
      }
    }
    
    return result;
  }
}
