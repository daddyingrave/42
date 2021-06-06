package com.github.andreyelagin.backtobackswe.tree;

public class AvlTree {

  public TreeNode insertAVL(int[] items, int threshold) {
    var root = new AvlNode(items[0]);
    for (int i = 1; i < items.length; i++) {
      insert(root, items[i], threshold);
    }

    return avlToTree(root);
  }
  
  private TreeNode avlToTree(AvlNode node) {
    var root = new TreeNode(node.val);

    root.left = avlToTree(node.left);
    root.right = avlToTree(node.right);
    
    return root;
  }
  
  private AvlNode insert(AvlNode node, int value, int threshold) {
    if (node == null) {
      return new AvlNode(value);
    }
    if (node.val < value) {
      node.right = insert(node.right, value, threshold);
    } else {
      node.left = insert(node.left, value, threshold);
    }
    
    int height = Math.max(height(node.left), height(node.right)) + 1;
    int rootBalance = balance(node);
    
    if (rootBalance > threshold) {
      if (balance(node.left) >= 0) {
        node = rotateRight(node);
      } else {
        node = rotateLeftRight(node);
      }
    } else if (rootBalance < -threshold) {
      if (balance(node.right) >= 0) {
        node = rotateLeft(node);
      } else {
        node = rotateRightLeft(node);
      }
    }
    
    return node;
  }

  private AvlNode rotateRightLeft(AvlNode node) {
    node.right = rotateRight(node.right);
    return rotateLeft(node);
  }

  private AvlNode rotateLeftRight(AvlNode node) {
    node.left = rotateLeft(node.left);
    return rotateRight(node);
  }

  private AvlNode rotateLeft(AvlNode node) {
    var tempRight = node.right;
    node.right = tempRight.left;
    
    tempRight.left = node;

    node.height = Math.max(height(node.left), height(node.right)) + 1;
    tempRight.height = Math.max(height(tempRight.left), height(tempRight.right)) + 1;
    
    return tempRight;
  }

  private AvlNode rotateRight(AvlNode node) {
    var tempLeft = node.left;
    node.left = tempLeft.right;
    
    tempLeft.right = node;
    
    node.height = Math.max(height(node.left), height(node.right)) + 1;
    tempLeft.height = Math.max(height(tempLeft.left), height(tempLeft.right)) + 1;
    
    return tempLeft;
  }

  private int height(AvlNode node) {
    if (node == null) {
      return -1;
    }
    
    return node.height;
  }
  
  private int balance(AvlNode node) {
    if (node == null) {
      return 0;
    }
    return height(node.left) - height(node.right);
  }
  
  private static class AvlNode {
    public int val;
    public AvlNode left;
    public AvlNode right;
    public int height;

    public AvlNode(int val) {
      this.val = val;
    }
  }
}
