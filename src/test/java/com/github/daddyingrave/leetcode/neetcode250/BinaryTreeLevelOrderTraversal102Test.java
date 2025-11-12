package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeLevelOrderTraversal102Test {
  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      var result = new ArrayList<List<Integer>>();
      var queue = new LinkedList<TreeNode>();
      if (root != null) {
        queue.add(root);
      }

      while (!queue.isEmpty()) {
        int length = queue.size();
        var currentRow = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
          var node = queue.poll();
          currentRow.add(node.val);
          if (node.left != null) {
            queue.add(node.left);
          }
          if (node.right != null) {
            queue.add(node.right);
          }
        }

        result.add(currentRow);
      }

      return result;
    }
  }

  @Test
  void test() {
    new Solution().levelOrder(null);
  }
}
