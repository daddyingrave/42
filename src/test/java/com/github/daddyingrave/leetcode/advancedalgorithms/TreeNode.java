package com.github.daddyingrave.leetcode.advancedalgorithms;

public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        '}';
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  //    3
  //   / \
  //  9  15
  //    /  \
  //   15   70
  public static TreeNode TreeNodeDefault() {
    var root = new TreeNode(7);
    var left = new TreeNode(3);
    var right = new TreeNode(15);
    var rightLeft = new TreeNode(9);
    var rightRight = new TreeNode(20);

    root.left = left;
    root.right = right;
    right.left = rightLeft;
    right.right = rightRight;

    return root;
  }
}
