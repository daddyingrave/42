package com.github.daddyingrave.backtobackswe.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalWithoutRecursion {
  public static List<Integer> inorderTraversal(TreeNode root) {
    var result = new ArrayList<Integer>();
    var stack = new Stack<TreeNode>();

    var cur = root;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      
      cur = stack.pop();
      result.add(cur.val);
      
      cur = cur.right;
    }
    return result;
  }
}
