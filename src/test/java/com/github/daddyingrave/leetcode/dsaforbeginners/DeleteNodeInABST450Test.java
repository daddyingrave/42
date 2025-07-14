package com.github.daddyingrave.leetcode.dsaforbeginners;

public class DeleteNodeInABST450Test {
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

  TreeNode findMin(TreeNode root) {
    var cur = root;
    while (cur.left != null) {
      cur = cur.left;
    }

    return cur;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.left == null && root.right == null) {
        return null;
      } else if (root.left == null ) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }else {
        var min = findMin(root.right);
        root.val = min.val;
        root.right = deleteNode(root.right, min.val);
      }
    }

    return root;
  }
}
