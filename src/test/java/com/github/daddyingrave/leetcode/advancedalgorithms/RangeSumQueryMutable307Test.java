package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RangeSumQueryMutable307Test {
  class NumArray {
    Node root;

    public NumArray(int[] nums) {
      root = build(nums, 0, nums.length - 1);
    }

    static private Node build(int[] nums, int left, int right) {
      if (left == right) {
        return new Node(left, right, nums[left]);
      }

      int mid = (right + left) / 2;
      var newNode = new Node(left, right, 0);
      newNode.leftNode = build(nums, left, mid);
      newNode.rightNode = build(nums, mid + 1, right);
      newNode.sum = newNode.leftNode.sum + newNode.rightNode.sum;

      return newNode;
    }


    public void update(int index, int val) {
      update(root, index, val);
    }

    static private void update(Node node, int index, int val) {
      if (node.leftIndex == index && node.rightIndex == index) {
        node.sum = val;
        return;
      }

      if (node.leftNode.rightIndex >= index) {
        update(node.leftNode, index, val);
      } else {
        update(node.rightNode, index, val);
      }

      node.sum = node.leftNode.sum + node.rightNode.sum;
    }

    public int sumRange(int left, int right) {
      return sumRange(root, left, right);
    }

    static private int sumRange(Node node, int left, int right) {
      if (node.leftIndex >= left && node.rightIndex <= right) {
        return node.sum;
      }
      if (right < node.leftIndex || left > node.rightIndex) {
        return 0;
      }

      return sumRange(node.leftNode, left, right) + sumRange(node.rightNode, left, right);
    }

    static class Node {
      int leftIndex;
      int rightIndex;
      Node leftNode;
      Node rightNode;
      int sum;

      public Node(int leftIndex, int rightIndex, int sum) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
        this.sum = sum;
      }
    }
  }

  @Test
  void test() {
    var segTree = new NumArray(new int[]{1, 2, 3, 4, 5});
    assertEquals(6, segTree.sumRange(0, 2));
  }

  @Test
  void tes2() {
    var segTree = new NumArray(new int[]{1, 3, 5});
    assertEquals(9, segTree.sumRange(0, 2));
    segTree.update(1, 2);
    assertEquals(8, segTree.sumRange(0, 2));
  }
}
