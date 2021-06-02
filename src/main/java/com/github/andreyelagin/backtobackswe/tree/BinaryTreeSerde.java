package com.github.andreyelagin.backtobackswe.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class BinaryTreeSerde {
  public String serialize(TreeNode root) {
    if (root == null) {
      return "null,";
    }

    var left = serialize(root.left);
    var right = serialize(root.right);

    return root.val + "," + left + right;
  }


  public TreeNode deserialize(String tree) {
    return deserializeHelper(
        Arrays
            .stream(tree.split(","))
            .map(i -> "null".equals(i) ? null : Integer.parseInt(i))
            .collect(Collectors.toCollection(LinkedList::new))
    );
  }

  private TreeNode deserializeHelper(Queue<Integer> tree) {
    var cur = tree.poll();
    if (cur == null) {
      return null;
    }

    var root = new TreeNode(cur);
    root.left = deserializeHelper(tree);
    root.right = deserializeHelper(tree);

    return root;
  }
}
