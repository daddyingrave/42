package com.github.daddyingrave.backtobackswe.tree;

import static com.github.daddyingrave.backtobackswe.tree.InorderTraversalWithoutRecursion.inorderTraversal;

class TreeNode {
  public int val;
  public TreeNode left, right;

  public TreeNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return inorderTraversal(this).toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TreeNode that = (TreeNode) o;
    
    return inorderTraversal(this).equals(inorderTraversal(that));
  }
}
