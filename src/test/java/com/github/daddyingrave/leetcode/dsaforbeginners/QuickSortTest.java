package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class QuickSortTest {
  class Pair {
    int key;
    String value;

    public Pair(int key, String value) {
      this.key = key;
      this.value = value;
    }

    // 1. Choose pivot element
    // 2. Move all the elements less than a pivot to the left and greater than pivot to the right
    //
  }

  public List<Pair> quickSort(List<Pair> pairs) {
    if (pairs == null || pairs.isEmpty() || pairs.size() == 1) {
      return pairs;
    }

    partition(pairs, 0, pairs.size() - 1);

    return pairs;
  }

  void partition(List<Pair> pairs, int left, int right) {
    if (right - left <= 0) {
      return;
    }

    var pivot = pairs.get(right);
    int ptr = left;
    for (int i = left; i < right; i++) {
      if (pairs.get(i).key < pivot.key) {
        var tmp = pairs.get(ptr);
        pairs.set(ptr, pairs.get(i));
        pairs.set(i, tmp);
        ptr++;
      }
    }

    var tmp = pairs.get(ptr);
    pairs.set(ptr, pivot);
    pairs.set(right, tmp);

    partition(pairs, left, ptr - 1);
    partition(pairs, ptr + 1, right);
  }

  @Test
  void test() {
    var list = new ArrayList<Pair>();
    list.add(new Pair(3, "cat"));
    list.add(new Pair(2, "dog"));
    list.add(new Pair(3, "bird"));

    quickSort(list);
    System.out.println();
  }
}
