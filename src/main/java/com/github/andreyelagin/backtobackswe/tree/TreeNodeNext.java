package com.github.andreyelagin.backtobackswe.tree;

import static com.github.andreyelagin.backtobackswe.tree.InorderTraversalWithoutRecursion.inorderTraversal;

public class TreeNodeNext {
  public int val;
  public TreeNodeNext next;
  public TreeNodeNext left, right;

  public TreeNodeNext(int val) {
    this.val = val;
  }
}
