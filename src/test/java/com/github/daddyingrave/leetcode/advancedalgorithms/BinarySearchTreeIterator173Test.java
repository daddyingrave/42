package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeIterator173Test {
  class BSTIterator {
    TreeNode root;
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
      var cur = root;
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
    }

    public int next() {
      var cur = stack.pop();
      int val = cur.val;

      if (cur.right != null) {
        stack.push(cur.right);
        cur = cur.right.left;
        while (cur != null) {
          stack.push(cur);
          cur = cur.left;
        }
      }

      return val;
    }

    public boolean hasNext() {
      return !stack.isEmpty();
    }
  }

  @Test
  void test() {
    BSTIterator bSTIterator = new BSTIterator(TreeNode.TreeNodeDefault());
    assertEquals(3, bSTIterator.next());
    assertEquals(7, bSTIterator.next());
    assertTrue(bSTIterator.hasNext());
    assertEquals(9, bSTIterator.next());
    assertTrue(bSTIterator.hasNext());
    assertEquals(15, bSTIterator.next());
    assertTrue(bSTIterator.hasNext());
    assertEquals(20, bSTIterator.next());
    assertFalse(bSTIterator.hasNext());
  }

  @Test
  void test2() {
    var root = new TreeNode(1);
    root.right = new TreeNode(2);

    BSTIterator bSTIterator = new BSTIterator(root);
    assertTrue(bSTIterator.hasNext());
    assertEquals(1, bSTIterator.next());
    assertTrue(bSTIterator.hasNext());
    assertEquals(2, bSTIterator.next());
    assertFalse(bSTIterator.hasNext());
  }
}
