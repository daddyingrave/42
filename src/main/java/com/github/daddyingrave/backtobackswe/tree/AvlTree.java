package com.github.daddyingrave.backtobackswe.tree;

public class AvlTree {

  public TreeNode insertAVL(int[] items, int threshold) {
    var root = new AVLNode(items[0]);

    for (int i = 1; i < items.length; i++) {
      root = insert(root, items[i], threshold);
    }

    return avlToTree(root);
    
  }

  private TreeNode avlToTree(AVLNode node) {
    if (node == null) {
      return null;
    }

    var root = new TreeNode(node.val);

    root.left = avlToTree(node.left);
    root.right = avlToTree(node.right);

    return root;
  }

  private AVLNode insert(AVLNode node, int value, int threshold) {
    if (node == null) {
      return new AVLNode(value);
    }

    if (value < node.val) {
      node.left = insert(node.left, value, threshold);
    } else {
      node.right = insert(node.right, value, threshold);
    }

    node.height  = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    int rootBalance = getBalance(node);

    if (rootBalance > threshold) {
      if (getBalance(node.left) >= 0) {
        node = rotateRight(node);
      } else {
        node = rotateLeftRight(node);
      }
    } else if (rootBalance < -threshold) {
      if (getBalance(node.right) <= 0) {
        node = rotateLeft(node);
      } else {
        node = rotateRightLeft(node);
      }
    }

    return node;
  }

  private AVLNode rotateRightLeft(AVLNode node) {
    node.right = rotateRight(node.right);
    return rotateLeft(node);
  }

  private AVLNode rotateLeftRight(AVLNode node) {
    node.left = rotateLeft(node.left);
    return rotateRight(node);
  }

  private AVLNode rotateLeft(AVLNode node) {
    var tempRight = node.right;
    
    node.right = tempRight.left;
    tempRight.left = node;

    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    tempRight.height = Math.max(getHeight(tempRight.left), getHeight(tempRight.right)) + 1;

    return tempRight;
  }

  private AVLNode rotateRight(AVLNode node) {
    var tempLeft = node.left;
    
    node.left = tempLeft.right;
    tempLeft.right = node;

    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    tempLeft.height = Math.max(getHeight(tempLeft.left), getHeight(tempLeft.right)) + 1;

    return tempLeft;
  }

  private int getHeight(AVLNode node) {
    if (node == null) {
      return -1;
    }

    return node.height;
  }

  private int getBalance(AVLNode node) {
    if (node == null) {
      return 0;
    }
    return getHeight(node.left) - getHeight(node.right);
  }

  private static class AVLNode {
    public int val;
    public AVLNode left;
    public AVLNode right;
    public int height;

    public AVLNode(int val) {
      this.val = val;
    }
  }
}
