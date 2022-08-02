package com.github.daddyingrave.backtobackswe.sorting;

import com.github.daddyingrave.backtobackswe.linkedlists.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

  MergeSort mergeSort = new MergeSort();
  
  @Test
  void mergeSort() {
    assertEquals(
        ListNode.build(List.of(1, 2, 3, 4, 5)),
        mergeSort.mergeSort(ListNode.build(List.of(5, 4, 3, 2, 1)))
    );
  }
}