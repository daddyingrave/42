package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeRightSideView199Test {
  class Solution {
    public List<Integer> rightSideView(TreeNode root) {
      var result = new ArrayList<Integer>();
      var queue = new LinkedList<TreeNode>();
      if (root != null) {
        queue.add(root);
      }

      while (!queue.isEmpty()) {
        int curSize = queue.size();
        result.add(queue.peek().val);

        for (int i = 0; i < curSize; i++) {
          var curNode = queue.poll();
          if (curNode.right != null) {
            queue.add(curNode.right);
          }
          if (curNode.left != null) {
            queue.add(curNode.left);
          }
        }
      }

      return result;
    }
  }

  @Test
  void test() {

  }
}
