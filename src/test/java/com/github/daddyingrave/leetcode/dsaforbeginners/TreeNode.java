package com.github.daddyingrave.leetcode.dsaforbeginners;

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

  //    3
  //   / \
  //  9  20
  //    /  \
  //   15   7
  public static TreeNode TreeNodeDefault() {
    var root = new TreeNode(3);
    var left = new TreeNode(9);
    var right = new TreeNode(20);
    var rightLeft = new TreeNode(15);
    var rightRight = new TreeNode(7);

    root.left = left;
    root.right = right;
    right.left = rightLeft;
    right.right = rightRight;

    return root;
  }
}
