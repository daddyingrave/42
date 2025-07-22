package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class MatrixBreadthFirstSearchTest {

  public int shortestPath(int[][] grid) {
    int length = 0;
    int rowMax = grid.length;
    int colMax = grid[0].length;
    Queue<int[]> queue = new LinkedList<>();
    var visited = new HashSet<String>();
    queue.offer(new int[]{0, 0});
    visited.add(0 + "/" + 0);

    var directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    while (!queue.isEmpty()) {
      int neighborsCount = queue.size();
      while (neighborsCount > 0) {
        int[] currentPosition = queue.poll();
        neighborsCount--;

        if (currentPosition[0] == rowMax - 1 && currentPosition[1] == colMax - 1) {
          return length;
        }

        for (int[] direction : directions) {
          var nextNeighbor = new int[]{currentPosition[0] + direction[0], currentPosition[1] + direction[1]};
          if (nextNeighbor[0] < 0 || nextNeighbor[1] < 0 || nextNeighbor[0] >= rowMax || nextNeighbor[1] >= colMax) {
            continue;
          }
          if (grid[nextNeighbor[0]][nextNeighbor[1]] == 1) {
            continue;
          }
          if (visited.contains(nextNeighbor[0] + "/" + nextNeighbor[1])) {
            continue;
          }

          queue.offer(nextNeighbor);
          visited.add(nextNeighbor[0] + "/" + nextNeighbor[1]);
        }
      }

      length++;
    }

    return -1;
  }

  @Test
  void test() {
    assertEquals(6, shortestPath(new int[][]{
        {0, 0, 0, 0},
        {1, 1, 0, 0},
        {0, 0, 0, 1},
        {0, 1, 0, 0}
    }));
  }
}
