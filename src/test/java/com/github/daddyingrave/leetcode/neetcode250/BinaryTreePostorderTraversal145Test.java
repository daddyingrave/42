package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreePostorderTraversal145Test {
  class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
      var result = new ArrayList<Integer>();
      var stack = new Stack<Node>();
      var cur = root;

      while (cur != null || !stack.isEmpty()) {
        if (cur == null) {
          var node = stack.pop();
          if (!node.visited) {
            cur = node.node.right;
            node.visited = true;
            stack.push(node);
          } else {
            result.add(node.node.val);
          }
        } else {
          stack.push(new Node(cur, false));
          cur = cur.left;
        }
      }

      return result;
    }

    class Node {
      TreeNode node;

      public Node(TreeNode node, boolean visited) {
        this.node = node;
        this.visited = visited;
      }

      boolean visited;
    }
  }

  @Test
  void test() {
    System.out.println(new Solution().postorderTraversal(TreeNode.TreeNodeDefault()));
  }
}
