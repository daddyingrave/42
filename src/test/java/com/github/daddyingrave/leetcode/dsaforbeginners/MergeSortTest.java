package com.github.daddyingrave.leetcode.dsaforbeginners;

import java.util.List;

public class MergeSortTest {
  class Pair {
    public int key;
    public String value;

    public Pair(int key, String value) {
      this.key = key;
      this.value = value;
    }
  }

  public List<Pair> mergeSort(List<Pair> pairs) {
    if (pairs.isEmpty() || pairs.size() == 1) {
      return pairs;
    }
    mergeSort(pairs, 0, pairs.size() - 1);
    return pairs;
  }

  void mergeSort(List<Pair> arr, int left, int right) {
    if (right - left == 0) {
      return;
    }

    int mid = ((right - left) / 2) + left;
    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right);

    merge(arr, left, mid, right);
  }

  void merge(List<Pair> arr, int left, int mid, int right) {
    int leftPtr = left;
    int rightPtr = mid + 1;

    Pair[] target = new Pair[right - left + 1];
    int targetPtr = 0;

    while (leftPtr <= mid && rightPtr <= right) {
      if (arr.get(leftPtr).key <= arr.get(rightPtr).key) {
        target[targetPtr] = arr.get(leftPtr++);
      } else {
        target[targetPtr] = arr.get(rightPtr++);
      }
      targetPtr++;
    }

    while (leftPtr <= mid) {
      target[targetPtr++] = arr.get(leftPtr++);
    }
    while (rightPtr <= right) {
      target[targetPtr++] = arr.get(rightPtr++);
    }

    for (int i = left, j = 0; j < target.length; i++, j++) {
      arr.set(i, target[j]);
    }
  }

//  @Test
//  void test1() {
//    int[] actual = new int[]{3, 2, 5, 1, 4};
//    int[] expected = new int[]{1, 2, 3, 4, 5};
//
//    sort(actual);
//    assertArrayEquals(expected, actual);
//  }
//
//  @Test
//  void test2() {
//    int[] actual = new int[]{3, 2, 1, 4};
//    int[] expected = new int[]{1, 2, 3, 4};
//
//    sort(actual);
//    assertArrayEquals(expected, actual);
//  }
}
