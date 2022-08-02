package com.github.daddyingrave.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EvenOddPartitionTest {

  EvenOddPartition evenOddPartition = new EvenOddPartition();

  @Test
  void oddEvenList() {
    assertEquals(
        ListNode.build(List.of(1, 3, 5, 2, 4)),
        evenOddPartition.oddEvenList(ListNode.build(List.of(1, 2, 3, 4, 5))));
    ;
  }
}