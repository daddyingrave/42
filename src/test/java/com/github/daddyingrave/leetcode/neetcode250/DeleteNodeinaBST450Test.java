package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteNodeinaBST450Test {
  class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
        return null;
      }

      if (key < root.val) {
        root.left = deleteNode(root.left, key);
      } else if (key > root.val) {
        root.right = deleteNode(root.right, key);
      } else {
        if (root.left == null) {
          return root.right;
        } else if (root.right == null) {
          return root.left;
        }

        var cur = root.right;
        while (cur.left != null) {
          cur = cur.left;
        }

        root.val = cur.val;
        root.right = deleteNode(root.right, root.val);
      }

      return root;
    }
  }

  @Test
  void test() {

  }
}
