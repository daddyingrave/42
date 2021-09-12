package com.github.andreyelagin.leetcode.trees;

public class PopulatingNextRightPointersInEachNode {
  public Node connect(Node root) {
    if (root == null || root.left == null) {
      return root;
    }
    
    var left = root.left;
    if (root.right != null) {
      left.next = root.right;
    }

    connectR(root.left);
    connectR(root.right);
    
    return root;
  }

  private void connectR(Node root) {
    if (root == null) {
      return;
    }
    
    if (root.left != null) {
      if (root.right != null) {
        root.left.next = root.right;
      } else if (root.next != null) {
        if (root.next.left != null) {
          root.left = root.next.left;
        } else if (root.next.right != null) {
          root.left = root.next.right;
        }
      }
      connectR(root.left);
    }
    
    if (root.right != null) {
      if (root.next != null && root.next.left != null) {
        root.right.next = root.next.left;
      } else if (root.next != null && root.next.right != null) {
        root.right.next = root.next.right;
      }
      connectR(root.right);
    }
  }
}
