package com.github.andreyelagin.leetcode.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

  NumberOfIslands solution = new NumberOfIslands();

  @Test
  void numIslands() {
    char[][] grid = new char[][]{
        new char[]{'1', '1', '1', '1', '0'},
        new char[]{'1', '1', '0', '1', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '0', '0', '0'},
    };

    char[][] grid2 = new char[][]{
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'1', '1', '0', '0', '0'},
        new char[]{'0', '0', '1', '0', '0'},
        new char[]{'0', '0', '0', '1', '1'},
    };

    char[][] grid3 = new char[][]{
        new char[]{'1', '1', '1'},
        new char[]{'0', '1', '0'},
        new char[]{'1', '1', '1'}
    };

    char[][] grid4 = new char[][]{
        new char[]{'1', '0', '1', '1', '1'},
        new char[]{'1', '0', '1', '0', '1'},
        new char[]{'1', '1', '1', '0', '1'}
    };

    assertEquals(1, solution.numIslands(grid));
    assertEquals(3, solution.numIslands(grid2));
    assertEquals(1, solution.numIslands(grid3));
    assertEquals(1, solution.numIslands(grid4));
  }
}
// [
//['1','0','1','1','1'],
//['1','0','1','0','1'],
//['1','1','1','0','1']
//]