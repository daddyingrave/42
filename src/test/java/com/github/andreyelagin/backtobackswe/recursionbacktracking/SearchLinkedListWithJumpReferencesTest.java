package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import com.github.andreyelagin.backtobackswe.recursionbacktracking.SearchLinkedListWithJumpReferences.ListNodeJump;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchLinkedListWithJumpReferencesTest {

  SearchLinkedListWithJumpReferences references = new SearchLinkedListWithJumpReferences();

  @Test
  void setJumpReferences() {
    var node1 = new ListNodeJump(-1);
    var node2 = new ListNodeJump(-1);
    var node3 = new ListNodeJump(-1);
    var node4 = new ListNodeJump(-1);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    node1.jump = node3;
    node2.jump = node4;
    node3.jump = node2;

    references.setJumpReferences(node1);

    var jumps = new ArrayList<Integer>();

    var cur = node1;
    while (cur != null) {
      jumps.add(cur.val);
      cur = cur.next;
    }

    assertEquals(List.of(0, 2, 1, 3), jumps);
  }

  @Test
  void setJumpReferences2() {
    var node0 = new ListNodeJump(-1);
    var node1 = new ListNodeJump(-1);
    var node2 = new ListNodeJump(-1);
    var node3 = new ListNodeJump(-1);

    node0.next = node1;
    node1.next = node2;
    node2.next = node3;

    node0.jump = node2;
    node1.jump = node3;

    references.setJumpReferences(node0);

    var jumps = new ArrayList<Integer>();

    var cur = node0;
    while (cur != null) {
      jumps.add(cur.val);
      cur = cur.next;
    }

    assertEquals(List.of(0, 3, 1, 2), jumps);
  }
}