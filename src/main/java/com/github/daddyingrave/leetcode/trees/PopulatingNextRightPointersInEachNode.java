package com.github.daddyingrave.leetcode.trees;

public class PopulatingNextRightPointersInEachNode {
  public Node connect(Node root) {
    if (root == null || root.left == null) {
      return root;
    }

    root.left.next = root.right;

    connectR(root.left);
    connectR(root.right);

    return root;
  }

  private void connectR(Node root) {
    if (root == null) {
      return;
    }

    if (root.left != null) {
      root.left.next = root.right;
      connectR(root.left);
    }

    if (root.right != null) {
      if (root.next != null) {
        root.right.next = root.next.left;
      }
      connectR(root.right);
    }
  }
}
