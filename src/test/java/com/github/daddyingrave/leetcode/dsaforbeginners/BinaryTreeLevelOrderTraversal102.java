package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return List.of();
    }

    var result = new ArrayList<List<Integer>>();
    var queue = new LinkedList<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      var nodesOfLevel = new ArrayList<Integer>();
      int currentQSize = queue.size();
      for (int i = 0; i < currentQSize; i++) {
        var node = queue.poll();
        nodesOfLevel.add(node.val);

        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }

      result.add(nodesOfLevel);
    }


    return result;
  }

  @Test
  void test() {
    var result = levelOrder(TreeNode.TreeNodeDefault());
    System.out.println(result);
  }
}
