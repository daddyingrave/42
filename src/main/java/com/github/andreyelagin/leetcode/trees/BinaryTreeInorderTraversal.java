package com.github.andreyelagin.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

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
}
