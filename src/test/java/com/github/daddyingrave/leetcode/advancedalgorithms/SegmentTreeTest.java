package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SegmentTreeTest {
  class SegmentTree {
    Node root;

    public SegmentTree(int[] nums) {
      root = init(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
      update(index, val, root);
    }

    void update(int index, int val, Node node) {
      if (node.leftIndex == index && node.rightIndex == index) {
        node.sum = val;
        return;
      }

      if (node.leftNode.rightIndex >= index) {
        update(index, val, node.leftNode);
      } else {
        update(index, val, node.rightNode);
      }

      node.sum = node.leftNode.sum + node.rightNode.sum;
    }

    public int query(int L, int R) {
      return query(L, R, root);
    }

    int query(int left, int right, Node node) {
      if (left <= node.leftIndex && node.rightIndex <= right) {
        return node.sum;
      }

      if (right < node.leftIndex || left > node.rightIndex) {
        return 0;
      }

      return query(left, right, node.leftNode) + query(left, right, node.rightNode);
    }

    static class Node {
      Node leftNode;
      Node rightNode;
      int leftIndex;
      int rightIndex;
      int sum;

      public Node() {
      }

      @Override
      public String toString() {
        return "Node{" +
            "leftIndex=" + leftIndex +
            ", rightIndex=" + rightIndex +
            ", sum=" + sum +
            '}';
      }
    }

    static Node init(int[] nums, int leftIndex, int rightIndex) {
      if (leftIndex == rightIndex) {
        var n = new Node();
        n.leftIndex = leftIndex;
        n.rightIndex = rightIndex;
        n.sum = nums[leftIndex];
        return n;
      }

      int mid = leftIndex + (rightIndex - leftIndex) / 2;

      var newNode = new Node();
      newNode.leftIndex = leftIndex;
      newNode.rightIndex = rightIndex;
      newNode.leftNode = init(nums, leftIndex, mid);
      newNode.rightNode = init(nums, mid + 1, rightIndex);
      newNode.sum = newNode.leftNode.sum + newNode.rightNode.sum;

      return newNode;
    }
  }


  @Test
  void test() {
    var segTree = new SegmentTree(new int[]{1, 2, 3, 4, 5});
    assertEquals(6, segTree.query(0, 2));
  }
}
