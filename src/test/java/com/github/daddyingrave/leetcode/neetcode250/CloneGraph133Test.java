package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class CloneGraph133Test {
  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  class Solution {
    public Node cloneGraph(Node node) {
      if (node == null) {
        return null;
      }

      return dfsClone(node, new HashMap<>());
    }

    Node dfsClone(Node node, Map<Node, Node> copies) {
      var newNode = new Node(node.val);
      copies.put(node, newNode);

      for (Node neighbor : node.neighbors) {
        if (copies.containsKey(neighbor)) {
          newNode.neighbors.add(copies.get(neighbor));
        } else {
          newNode.neighbors.add(dfsClone(neighbor, copies));
        }
      }

      return newNode;
    }
  }

  @Test
  void test() {

  }
}
