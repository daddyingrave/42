package com.github.daddyingrave.leetcode.neetcode250;

import com.github.daddyingrave.leetcode.advancedalgorithms.PrefixAndSuffixSearch745Test;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class AccountsMerge721Test {
  class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
      var emailIdx = new HashMap<String, Integer>();
      var emails = new ArrayList<String>();
      var emailToAccount = new HashMap<Integer, Integer>();

      int m = 0;
      for (int accId = 0; accId < accounts.size(); accId++) {
        List<String> account = accounts.get(accId);
        for (int i = 1; i < account.size(); i++) {
          String email = account.get(i);
          if (!emailIdx.containsKey(email)) {
            emails.add(email);
            emailIdx.put(email, m);
            emailToAccount.put(m, accId);
            m++;
          }
        }
      }

      var adj = new ArrayList<List<Integer>>();
      for (int i = 0; i < m; i++) {
        adj.add(new ArrayList<>());
      }
      for (List<String> account : accounts) {
        for (int i = 2; i < account.size(); i++) {
          int id1 = emailIdx.get(account.get(i));
          int id2 = emailIdx.get(account.get(i - 1));
          adj.get(id1).add(id2);
          adj.get(id2).add(id1);
        }
      }

      boolean[] visited = new boolean[m];
      var emailGroup = new HashMap<Integer, List<String>>();
      for (int i = 0; i < m; i++) {
        if (!visited[i]) {
          int accId = emailToAccount.get(i);
          emailGroup.putIfAbsent(accId, new ArrayList<>());
          dfs(i, accId, visited, emailGroup, emails, adj);
        }
      }

      var result = new ArrayList<List<String>>();
      for (Integer accId : emailGroup.keySet()) {
        var group = emailGroup.get(accId);
        group.sort(Comparator.naturalOrder());
        var merged = new ArrayList<String>();
        merged.add(accounts.get(accId).get(0));
        merged.addAll(group);
        result.add(merged);
      }

      return result;
    }

    void dfs(int node,
             int accId,
             boolean[] visited,
             Map<Integer, List<String>> emailGroup,
             List<String> emails,
             List<List<Integer>> adj
    ) {
      visited[node] = true;
      emailGroup.get(accId).add(emails.get(node));
      for (Integer neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
          dfs(neighbor, accId, visited, emailGroup, emails, adj);
        }
      }
    }
  }

  @Test
  void test() {

  }
}
