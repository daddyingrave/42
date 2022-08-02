package com.github.daddyingrave.leetcode.trees;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementInBST {
  public int kthSmallest(TreeNode root, int k) {
    var heap = new PriorityQueue<Integer>(Comparator.reverseOrder());

    traverse(root, k, heap);
    
    return heap.peek();
  }

  private void traverse(TreeNode node, int k, Queue<Integer> heap) {
    if (node == null) {
      return;
    }
    
    int cur = node.val;
    if (heap.size() < k) {
      heap.offer(cur);
    } else if (heap.size() > 0 && heap.peek() > cur) {
      heap.remove();
      heap.offer(cur);
    }

    traverse(node.left, k, heap);
    traverse(node.right, k, heap);
  }
}
