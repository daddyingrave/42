package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeRightSideView199Test {
  public List<Integer> rightSideView(TreeNode root) {
    var result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    var queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      result.add(queue.peek().val);

      int stackSize = queue.size();
      while (stackSize > 0) {
        var node = queue.pop();
        if (node.right != null) {
          queue.offer(node.right);
        }
        if (node.left != null) {
          queue.offer(node.left);
        }

        stackSize--;
      }
    }

    return result;
  }

  @Test
  void test() {
    assertEquals(List.of(3, 20, 7), rightSideView(TreeNode.TreeNodeDefault()));
  }
}
