package com.github.daddyingrave.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PascalsTriangleII {
  public List<Integer> getRow(int rowIndex) {
    var triangle = new HashMap<Integer, List<Integer>>();
    var firstRow = new ArrayList<Integer>();
    firstRow.add(1);
    triangle.put(0, firstRow);

    rec(triangle, 0, rowIndex, 1);

    return triangle.get(rowIndex);
  }

  private void rec(Map<Integer, List<Integer>> triangle, int index, int targetRow, int curRow) {
    if (curRow > targetRow) {
      return;
    }

    var prevRow = triangle.get(curRow - 1);
    var row = triangle.computeIfAbsent(curRow, _n -> new ArrayList<>());

    int leftParent = parent(prevRow, index - 1);
    int rightParent = parent(prevRow, index);

    row.add(leftParent + rightParent);

    if (row.size() == curRow + 1) {
      curRow++;
      index = 0;
    } else {
      index++;
    }

    rec(triangle, index, targetRow, curRow);
  }

  private int parent(List<Integer> row, int index) {
    if (index < 0 || index >= row.size()) {
      return 0;
    } else {
      return row.get(index);
    }
  }
}
