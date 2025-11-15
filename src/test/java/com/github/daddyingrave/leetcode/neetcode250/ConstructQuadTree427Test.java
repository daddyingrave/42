package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstructQuadTree427Test {
  class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
      this.val = false;
      this.isLeaf = false;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = null;
      this.topRight = null;
      this.bottomLeft = null;
      this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
      this.val = val;
      this.isLeaf = isLeaf;
      this.topLeft = topLeft;
      this.topRight = topRight;
      this.bottomLeft = bottomLeft;
      this.bottomRight = bottomRight;
    }
  }

  class Solution {
    public Node construct(int[][] grid) {
      return construct(grid, grid.length, 0, 0);
    }

    Node construct(int[][] grid, int n, int row, int col) {
      boolean allSame = true;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[row][col] != grid[row + i][col + j]) {
            allSame = false;
            break;
          }
        }
      }

      if (allSame) {
        return new Node(grid[row][col] == 1, true);
      }

      int mid = n / 2;
      var topLeft = construct(grid, mid, row, col);
      var topRight = construct(grid, mid, row, col + mid);
      var bottomLeft = construct(grid, mid, row + mid, col);
      var bottomRight = construct(grid, mid, row + mid, col + mid);

      return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
  }

  @Test
  void test() {

  }
}
