package com.github.andreyelagin.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindLeavesOfBinaryTree {
  public List<List<Integer>> findLeaves(TreeNode root) {
    var leaves = new LinkedHashMap<Integer, List<Integer>>();
    height(root, leaves);
    return new ArrayList<>(leaves.values());
  }

  private int height(TreeNode node, Map<Integer, List<Integer>> leaves) {
    if (node == null) {
      return -1;
    }

    int left = height(node.left, leaves);
    int right = height(node.right, leaves);

    int height = Math.max(left, right) + 1;

    leaves.compute(height, (k, v) -> {
      if (v == null) {
        var list = new ArrayList<Integer>();
        list.add(node.val);
        return list;
      } else {
        v.add(node.val);
        return v;
      }
    });

    return height;
  }

//  better performance
//  public List<List<Integer>> findLeaves(TreeNode root) {
//    List<List<Integer>> res = new ArrayList<>();
//    height(root, res);
//    return res;
//  }
//
//  private int height(TreeNode node, List<List<Integer>> res) {
//    if (null == node) return -1;
//    int level = 1 + Math.max(height(node.left, res), height(node.right, res));
//    if (res.size() < level + 1) res.add(new ArrayList<>());
//    res.get(level).add(node.val);
//    return level;
//  }
}
