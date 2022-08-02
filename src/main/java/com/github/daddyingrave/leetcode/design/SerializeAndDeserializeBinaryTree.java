package com.github.daddyingrave.leetcode.design;

import com.github.daddyingrave.leetcode.trees.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class SerializeAndDeserializeBinaryTree {
  public String serialize(TreeNode root) {
    if (root == null) {
      return "n";
    }

    return root.val + "_" + serialize(root.left) + "_" + serialize(root.right);
  }


  public TreeNode deserialize(String data) {
    return deser(new LinkedList<String>(Arrays.asList(data.split("_"))));
  }

  private TreeNode deser(LinkedList<String> chars) {
    if (!chars.isEmpty()) {
      var val = chars.removeFirst();
      if ("n".equals(val)) {
        return null;
      }
      var root = new TreeNode(Integer.parseInt(val));
      root.left = deser(chars);
      root.right = deser(chars);
      return root;
    }
    return null;
  }
}
