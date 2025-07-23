package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ShortestPathInBinaryMatrix1091Test {
  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1) {
      return -1;
    }

    int rowMax = grid.length;
    int colMax = grid[0].length;
    var neighbours = new LinkedList<PointWithLength>();
    Point start = new Point(0, 0);
    neighbours.offer(new PointWithLength(start, 1));

    var directions = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1},
        {0, -1}, {0, 1},
        {1, -1}, {1, 0}, {1, 1}
    };

    while (!neighbours.isEmpty()) {
      int currentSize = neighbours.size();
      while (currentSize > 0) {
        var currentNeighbour = neighbours.poll();
        currentSize--;
        if (currentNeighbour.point.row == rowMax - 1 && currentNeighbour.point.col == colMax - 1) {
          return currentNeighbour.length;
        }

        for (int[] direction : directions) {
          var nextTurn = new Point(currentNeighbour.point.row + direction[0], currentNeighbour.point.col + direction[1]);
          if (nextTurn.col < 0 || nextTurn.row < 0 || nextTurn.row >= colMax || nextTurn.col >= rowMax) {
            continue;
          }

          if (grid[nextTurn.row][nextTurn.col] == 0) {
            grid[nextTurn.row][nextTurn.col] = 1;
            neighbours.offer(new PointWithLength(nextTurn, currentNeighbour.length + 1));
          }
        }
      }
    }

    return -1;
  }

  record Point(int row, int col) {
  }

  record PointWithLength(Point point, int length) {
  }

  @Test
  void test() {
    assertEquals(2, shortestPathBinaryMatrix(new int[][]{
        {0, 1},
        {1, 0},
    }));

    assertEquals(4, shortestPathBinaryMatrix(new int[][]{
        {0, 0, 0},
        {1, 1, 0},
        {1, 1, 0}
    }));

    assertEquals(-1, shortestPathBinaryMatrix(new int[][]{
        {1, 0, 0},
        {1, 1, 0},
        {1, 1, 0}
    }));

    assertEquals(4, shortestPathBinaryMatrix(new int[][]{
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    }));

    assertEquals(7, shortestPathBinaryMatrix(new int[][]{
        {0, 1, 0, 0, 0, 0},
        {0, 1, 1, 1, 1, 1},
        {0, 0, 0, 0, 1, 1},
        {0, 1, 0, 0, 0, 1},
        {1, 0, 0, 1, 0, 1},
        {0, 0, 1, 0, 1, 0}
    }));
  }
}
