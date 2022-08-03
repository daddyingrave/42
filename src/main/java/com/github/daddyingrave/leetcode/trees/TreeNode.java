package com.github.daddyingrave.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode() {
  }

  public TreeNode(int val) {
    this.val = val;
  }

  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  @Override
  public String toString() {
    var d = new LinkedHashMap<Integer, List<String>>();
    rec(this, 0, d);

    var sb = new StringBuilder();
    int indent = d.size() + 1;

    d.forEach((lvl, nodes) -> {
      sb.append(" ".repeat(indent - lvl));
      nodes.forEach(n -> sb.append(n).append(" "));
      sb.append("\n");
    });

    return sb.toString();
  }

  private void rec(TreeNode h, int level, LinkedHashMap<Integer, List<String>> storage) {
    if (h == null) {
      storage.compute(level, (lvl, row) -> {
        if (row == null) {
          var r = new ArrayList<String>();
          r.add("n");
          return r;
        } else {
          row.add("n");
          return row;
        }
      });
    } else {
      storage.compute(level, (lvl, row) -> {
        if (row == null) {
          var r = new ArrayList<String>();
          r.add(Integer.toString(h.val));
          return r;
        } else {
          row.add(Integer.toString(h.val));
          return row;
        }
      });
      rec(h.left, level + 1, storage);
      rec(h.right, level + 1, storage);
    }
  }
}