package com.github.andreyelagin.backtobackswe.tree;

import java.util.Objects;

class TreeNode {
  public int val;
  public TreeNode left, right;

  public TreeNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    return "TreeNode{" +
        "val=" + val +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TreeNode treeNode = (TreeNode) o;
    
    return val == treeNode.val
        && (treeNode.left == left || treeNode.left.equals(left))
        && (treeNode.right == right || treeNode.right.equals(right));
  }
}
