package com.github.andreyelagin.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElementFromTheEndTest {
  
  RemoveElementFromTheEnd remove = new RemoveElementFromTheEnd();
  
  @Test
  void removeKthToLast() {
//    assertEquals(
//        ListNode.build(List.of(1, 2, 5, 7)),
//        remove.removeKthToLast(ListNode.build(List.of(1, 2, 5, 6, 7)), 2)
//    );
    assertEquals(
        ListNode.build(List.of(2, 5, 6, 7)),
        remove.removeKthToLast(ListNode.build(List.of(1, 2, 5, 6, 7)), 5)
    );
  }
}