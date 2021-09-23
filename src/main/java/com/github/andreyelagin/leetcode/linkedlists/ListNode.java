package com.github.andreyelagin.leetcode.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
  
  public List<Integer> toList() {
    var list = new ArrayList<Integer>();
    
    var cur = this;
    while (cur != null) {
      list.add(cur.val);
      cur = cur.next;
    }
    
    return list;
  }

  public static ListNode fromList(List<Integer> source) {
    var dummy = new ListNode();
    var head = dummy;

    for (Integer v : source) {
      head.next = new ListNode(v);
      head = head.next;
    }
    
    return dummy.next;
  }
}
