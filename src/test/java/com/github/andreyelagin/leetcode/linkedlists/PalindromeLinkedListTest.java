package com.github.andreyelagin.leetcode.linkedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeLinkedListTest {

  PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
  
  @Test
  void isPalindrome() {
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(1);
    
    node1.next = node2;
    node2.next = node3;
   
    assertTrue(palindromeLinkedList.isPalindrome(node1));
  }

  @Test
  void isPalindrome2() {
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(2);
    var node4 = new ListNode(1);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    assertTrue(palindromeLinkedList.isPalindrome(node1));
  }

  @Test
  void isPalindrome3() {
    var node1 = new ListNode(1);
    var node2 = new ListNode(2);
    var node3 = new ListNode(2);
    var node4 = new ListNode(3);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;

    assertFalse(palindromeLinkedList.isPalindrome(node1));
  }
}