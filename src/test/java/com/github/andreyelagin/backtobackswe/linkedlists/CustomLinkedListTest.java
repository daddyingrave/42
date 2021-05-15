package com.github.andreyelagin.backtobackswe.linkedlists;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

  @Test
  void get() {
    var list = new CustomLinkedList(ListNode.build(List.of(1, 2, 3, 4, 5)));
    assertEquals(1, list.get(0));
    assertEquals(-1, list.get(5));
    assertEquals(3, list.get(2));
  }

  @Test
  void addAtHead() {
    var list = new CustomLinkedList(ListNode.build(List.of(1, 2, 3, 4, 5)));
    var expectedList = new CustomLinkedList(ListNode.build(List.of(666, 1, 2, 3, 4, 5)));
    list.addAtHead(666);
    assertEquals(expectedList, list);
    
    // add to empty list
    var emptyList = new CustomLinkedList();
    var emptyExpected = new CustomLinkedList(ListNode.build(List.of(1)));
    emptyList.addAtHead(1);
    assertEquals(emptyExpected, emptyList);
  }

  @Test
  void addAtTail() {
    var list = new CustomLinkedList(ListNode.build(List.of(1, 2, 3, 4, 5)));
    var expectedList = new CustomLinkedList(ListNode.build(List.of(1, 2, 3, 4, 5, 666)));
    list.addAtTail(666);
    assertEquals(expectedList, list);

    // add to empty list
    var emptyList = new CustomLinkedList();
    var emptyExpected = new CustomLinkedList(ListNode.build(List.of(1)));
    emptyList.addAtTail(1);
    assertEquals(emptyExpected, emptyList);
  }

  @Test
  void addAtIndex() {
    var list = new CustomLinkedList(ListNode.build(List.of(1, 2, 3, 4, 5)));
    var expectedList = new CustomLinkedList(ListNode.build(List.of(1, 2, 666, 3, 4, 5)));
    list.addAtIndex(1, 666);
    assertEquals(expectedList, list);
  }

  @Test
  void deleteAtIndex() {
    var list = new CustomLinkedList(ListNode.build(List.of(1, 2, 3, 4, 5)));
    var expectedList = new CustomLinkedList(ListNode.build(List.of(1, 2, 4, 5)));
    list.deleteAtIndex(2);
    assertEquals(expectedList, list);

    list.deleteAtIndex(0);
    assertEquals(new CustomLinkedList(ListNode.build(List.of(2, 4, 5))), list);
  }
}