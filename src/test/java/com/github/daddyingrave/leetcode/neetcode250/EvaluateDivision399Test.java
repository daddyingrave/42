package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class EvaluateDivision399Test {
  class Solution {
    record Pair(String key, Double val) {
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {


      var adj = new HashMap<String, List<Pair>>();
      for (int i = 0; i < equations.size(); i++) {
        List<String> eq = equations.get(i);

        String a = eq.get(0);
        String b = eq.get(1);
        adj.putIfAbsent(a, new ArrayList<>());
        adj.putIfAbsent(b, new ArrayList<>());
        adj.get(a).add(new Pair(b, values[i]));
        adj.get(b).add(new Pair(a, 1 / values[i]));
      }

      double[] res = new double[queries.size()];
      for (int i = 0; i < queries.size(); i++) {
        var src = queries.get(i).get(0);
        var target = queries.get(i).get(1);
        res[i] = dfs(src, target, adj, new HashSet<>());
      }

      return res;
    }

    double dfs(String src, String target, Map<String, List<Pair>> adj, Set<String> visited) {
      if (!adj.containsKey(src) || !adj.containsKey(target)) {
        return -1.0;
      }

      if (src.equals(target)) {
        return 1.0;
      }

      visited.add(src);

      for (Pair pair : adj.get(src)) {
        if (!visited.contains(pair.key)) {
          double result = dfs(pair.key, target, adj, visited);
          if (result != -1) {
            return pair.val * result;
          }
        }
      }

      return -1;
    }
  }

  @Test
  void test() {

  }
}
