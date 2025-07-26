package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CloneGraph133Test {

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }

    var oldToNew = new HashMap<Node, Node>();

    dfs(node, oldToNew);

    return oldToNew.get(node);
  }

  Node dfs(Node node, Map<Node, Node> oldToNew) {
    if (node == null) {
      return null;
    }

    if (oldToNew.containsKey(node)) {
      return oldToNew.get(node);
    }

    var newNode = new Node(node.val);
    oldToNew.put(node, newNode);

    for (Node neighbor : node.neighbors) {
      newNode.neighbors.add(dfs(neighbor, oldToNew));
    }

    return newNode;
  }

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

    @Override
    public String toString() {

      return "Node{" +
          "val=" + val +
          ", neighbors=" + neighbors.stream().map(n -> n.val).toList() +
          '}';
    }
  }

  @Test
  void test() {
    var node1 = new Node(1);
    var node2 = new Node(2);
    var node3 = new Node(3);
    var node4 = new Node(4);
    node1.neighbors = List.of(node2, node4);
    node2.neighbors = List.of(node1, node3);
    node3.neighbors = List.of(node2, node4);
    node4.neighbors = List.of(node1, node3);

    cloneGraph(node1);
  }
}
