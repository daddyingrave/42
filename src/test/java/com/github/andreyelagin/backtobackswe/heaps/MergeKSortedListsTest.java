package com.github.andreyelagin.backtobackswe.heaps;

import com.github.andreyelagin.backtobackswe.linkedlists.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {

  MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
  
  @Test
  void mergeKLists() {
    assertEquals(
        ListNode.build(List.of(-1, 2, 3, 3, 6)),
        mergeKSortedLists.mergeKLists(
            new ListNode[] {
                ListNode.build(List.of(-1, 3)),
                ListNode.build(List.of(2, 3)),
                ListNode.build(List.of(6))
            }
        )
    );
  }
}