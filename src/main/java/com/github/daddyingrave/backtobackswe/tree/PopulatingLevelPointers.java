package com.github.daddyingrave.backtobackswe.tree;

public class PopulatingLevelPointers {
  public TreeNodeNext populate(TreeNodeNext root) {
    if (root == null) {
      return null;
    }

    if (root.left != null) {
      if (root.right != null) {
        root.left.next = root.right;
      } else {
        root.left.next = findNext(root.next);
      }
    }

    if (root.right != null) {
      root.right.next = findNext(root.next);
    }

    root.left = populate(root.left);
    root.right = populate(root.right);

    return root;
  }

  private TreeNodeNext findNext(TreeNodeNext root) {
    if (root == null) {
      return null;
    } else if (root.left != null) {
      return root.left;
    } else if (root.right != null) {
      return root.right;
    } else {
      return findNext(root.next);
    }
  }
}
