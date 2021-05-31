package com.github.andreyelagin.backtobackswe.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static com.github.andreyelagin.backtobackswe.tree.InorderTraversalWithoutRecursion.inorderTraversal;

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
