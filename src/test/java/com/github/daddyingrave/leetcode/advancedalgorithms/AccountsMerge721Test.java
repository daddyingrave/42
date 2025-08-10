package com.github.daddyingrave.leetcode.advancedalgorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class AccountsMerge721Test {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    var emailToAccount = new HashMap<String, Integer>();
    var uf = new UnionFind(accounts.size());

    for (int i = 0; i < accounts.size(); i++) {
      var curAccount = accounts.get(i);
      for (String email : curAccount.subList(1, curAccount.size())) {
        var matchedAccount = emailToAccount.get(email);
        if (matchedAccount != null) {
          uf.union(matchedAccount, i);
        }
        emailToAccount.put(email, uf.find(i));
      }
    }

    var result = new ArrayList<List<String>>();
    for (int i = 0; i < accounts.size(); i++) {
      result.add(null);
    }

    for (int i = 0; i < accounts.size(); i++) {
      int targetAccount = uf.find(i);
      List<String> currentAccount = accounts.get(i);

      var targetAccountEmails = result.get(targetAccount);
      if (targetAccountEmails == null) {
        targetAccountEmails = currentAccount;
        result.set(targetAccount, targetAccountEmails);
      } else {
        targetAccountEmails.addAll(currentAccount.subList(1, currentAccount.size()));
      }
    }

    return result.stream()
        .filter(Objects::nonNull)
        .map(l -> {
          List<String> unique = new ArrayList<>(new HashSet<>(l.subList(1, l.size())));
          unique.sort(Comparator.naturalOrder());
          unique.add(0, l.get(0));
          return unique;
        })
        .toList();
  }

  class UnionFind {
    final int[] parents;
    final int[] rank;

    public UnionFind(int n) {
      parents = new int[n];
      rank = new int[n];

      for (int i = 1; i < n; i++) {
        parents[i] = i;
        rank[i] = 0;
      }
    }

    public int find(int val) {
      int parent = parents[val];
      while (parents[parent] != parent) {
        parents[parent] = parents[parents[parent]];
        parent = parents[parent];
      }

      return parent;
    }

    public boolean union(int x, int y) {
      int xParent = find(x);
      int yParent = find(y);
      if (xParent == yParent) {
        return false;
      }

      int xRank = rank[x];
      int yRank = rank[y];

      if (xRank > yRank) {
        parents[yParent] = xParent;
      } else if (xRank < yRank) {
        parents[xParent] = yParent;
      } else {
        parents[xParent] = yParent;
        rank[yParent] += 1;
      }

      return true;
    }
  }

  @Test
  void test() {
    assertEquals(3,
        accountsMerge(List.of(
            new ArrayList<>(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com")),
            new ArrayList<>(List.of("John", "johnsmith@mail.com", "john00@mail.com")),
            new ArrayList<>(List.of("Mary", "mary@mail.com")),
            new ArrayList<>(List.of("John", "johnnybravo@mail.com"))
        )).size()
    );

  }
}
