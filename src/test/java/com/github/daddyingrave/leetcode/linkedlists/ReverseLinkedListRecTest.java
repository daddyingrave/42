package com.github.daddyingrave.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListRecTest {

  ReverseLinkedListRec reverseLinkedListRec = new ReverseLinkedListRec();

  @Test
  void reverseList() {
    var given = ListNode.fromList(List.of(1, 2, 3, 4));
    var expected = ListNode.fromList(List.of(4, 3, 2, 1));

    var actual = reverseLinkedListRec.reverseList(given);

    assertEquals(expected, actual);
  }

  @Test
  void reverseList2() {
    var given = ListNode.fromList(List.of(1));
    var expected = ListNode.fromList(List.of(1));

    var actual = reverseLinkedListRec.reverseList(given);

    assertEquals(expected, actual);
  }

  @Test
  void reverseList3() {
    var given = ListNode.fromList(List.of());
    var expected = ListNode.fromList(List.of());

    var actual = reverseLinkedListRec.reverseList(given);

    assertEquals(expected, actual);
  }
}