package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SerializeandDeserializeBinaryTree297Test {
  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      var sb = new StringBuilder();
      dfsS(root, sb);
      return sb.toString();
    }

    void dfsS(TreeNode node, StringBuilder sb) {
      if (node == null) {
        sb.append("n,");
        return;
      }

      sb.append(node.val);
      sb.append(",");

      dfsS(node.left, sb);
      dfsS(node.right, sb);
    }

    public TreeNode deserialize(String data) {
      String[] split = data.split(",");

      return dfsD(split, new int[]{0});
    }

    TreeNode dfsD(String[] nodes, int[] index) {
      if (index[0] >= nodes.length || nodes[index[0]].equals("n")) {
        index[0]++;
        return null;
      }

      var root = new TreeNode(Integer.parseInt(nodes[index[0]]));
      index[0]++;
      root.left = dfsD(nodes, index);
      root.right = dfsD(nodes, index);

      return root;
    }
  }


  @Test
  void test() {
    Codec codec = new Codec();
    TreeNode deserialize = codec.deserialize(codec.serialize(TreeNode.TreeNodeDefault()));
    System.out.println(deserialize);
  }
}
