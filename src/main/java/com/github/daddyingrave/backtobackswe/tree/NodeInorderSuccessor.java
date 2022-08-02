package com.github.daddyingrave.backtobackswe.tree;

public class NodeInorderSuccessor {
  public TreeNodeParent inorderSuccessor(TreeNodeParent node, int x) {
    if (node != null) {
      if (node.val == x) {
        return findSuccessor(node);
      }

      var left = findSuccessor(node.left);
      var right = findSuccessor(node.right);

      if (left != null) {
        return left;
      } else if (right != null) {
        return right;
      }
    }

    return null;
  }

  private TreeNodeParent findSuccessor(TreeNodeParent nodeParent) {
    var ptr = nodeParent;
    if (ptr.right != null) {
      while (ptr.left != null) {
        ptr = ptr.left;
      }
      return ptr;
    }

    while (ptr.parent != null && ptr.parent.right.val == ptr.val) {
      ptr = ptr.parent;
    }

    return ptr.parent;
  }
}
