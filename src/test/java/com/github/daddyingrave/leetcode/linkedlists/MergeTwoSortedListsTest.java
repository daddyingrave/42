package com.github.daddyingrave.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

  MergeTwoSortedLists solution = new MergeTwoSortedLists();

  @Test
  void merge() {
    assertEquals(
        List.of(1, 1, 2, 3, 4, 4),
        solution.mergeTwoLists(
            ListNode.fromList(List.of(1, 2, 4)),
            ListNode.fromList(List.of(1, 3, 4))
        ).toList()
    );
  }
}