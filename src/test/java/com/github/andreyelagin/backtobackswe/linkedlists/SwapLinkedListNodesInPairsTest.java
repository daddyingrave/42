package com.github.andreyelagin.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SwapLinkedListNodesInPairsTest {

  SwapLinkedListNodesInPairs swap = new SwapLinkedListNodesInPairs();
  
  @Test
  void swapInPairs() {
    assertEquals(
        ListNode.build(List.of(2, 1, 4, 3, 6, 5)),
        swap.swapInPairs(ListNode.build(List.of(1, 2, 3, 4, 5, 6)))
    );
    assertEquals(
        ListNode.build(List.of(2, 1)),
        swap.swapInPairs(ListNode.build(List.of(1, 2)))
    );
    assertEquals(
        ListNode.build(List.of(1)),
        swap.swapInPairs(ListNode.build(List.of(1)))
    );
    assertEquals(
        ListNode.build(List.of(2, 1, 4, 3, 5)),
        swap.swapInPairs(ListNode.build(List.of(1, 2, 3, 4, 5)))
    );
  }
}