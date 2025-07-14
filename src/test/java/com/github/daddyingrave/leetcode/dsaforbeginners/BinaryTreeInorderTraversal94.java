package com.github.daddyingrave.leetcode.dsaforbeginners;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    var list = new ArrayList<Integer>();
    inorder(root, list);
    return list;
  }

  void inorder(TreeNode node, List<Integer> vals) {
    if (node == null) {
      return;
    }

    inorder(node.left, vals);
    vals.add(node.val);
    inorder(node.right, vals);
  }
}
