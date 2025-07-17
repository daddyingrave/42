package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class KthSmallestElementInABST230Test {
  public int kthSmallestStupid(TreeNode root, int k) {
    counter = k;
    kth(root);
    return res.val;
  }

  int counter;
  TreeNode res;

  void kth(TreeNode root) {
    if (root == null) {
      return;
    }

    kth(root.left);
    counter--;
    if (counter == 0) {
      res = root;
      return;
    }

    kth(root.right);
  }

  public int kthSmallest(TreeNode root, int k) {
    var stack = new Stack<TreeNode>();

    var cur = root;
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }

    while (true) {
      var curNode = stack.pop();

      k--;
      if (k == 0) {
        return curNode.val;
      }

      if (curNode.right != null) {
        cur = curNode.right;
        while (cur != null) {
          stack.push(cur);
          cur = cur.left;
        }
      }
    }
  }

  @Test
  void test() {
    var root = new TreeNode(3);
    var left = new TreeNode(1);
    var leftRight = new TreeNode(2);
    var right = new TreeNode(4);

    root.left = left;
    root.right = right;
    left.right = leftRight;

    assertEquals(1, kthSmallestStupid(root, 1));
  }
}
