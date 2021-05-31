package com.github.andreyelagin.backtobackswe.tree;

import static com.github.andreyelagin.backtobackswe.tree.InorderTraversalWithoutRecursion.inorderTraversal;

public class ModifyBinaryTree {
  public TreeNode insert(TreeNode node, int nodeToInsert) {
    if (node == null) {
      return new TreeNode(nodeToInsert);
    }

    if (nodeToInsert < node.val) {
      node.left = insert(node.left, nodeToInsert);
    } else {
      node.right = insert(node.right, nodeToInsert);
    }

    return node;
  }

  public TreeNode delete(TreeNode node, int nodeToDelete) {
    if (node == null) {
      return null;
    }

    if (nodeToDelete < node.val) {
      node.left = delete(node.left, nodeToDelete);
    } else if (nodeToDelete > node.val) {
      node.right = delete(node.right, nodeToDelete);
    } else {
      if (node.left == null) {
        return node.right;
      } else if (node.right == null) {
        return node.left;
      }

      var nextInorder = getNextInorderNode(node.right);
      node.val = nextInorder.val;

      node.right = delete(node.right, nextInorder.val);
    }

    return node;
  }

  private TreeNode getNextInorderNode(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode curr = root;
    while (curr.left != null) {
      curr = curr.left;
    }

    return curr;
  }
}
