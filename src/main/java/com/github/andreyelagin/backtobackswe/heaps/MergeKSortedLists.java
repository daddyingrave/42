package com.github.andreyelagin.backtobackswe.heaps;

import com.github.andreyelagin.backtobackswe.linkedlists.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
  public ListNode mergeKLists(ListNode[] lists) {
    var heap = new PriorityQueue<ListNode>(Comparator.comparingInt(head -> head.val));

    for (ListNode list : lists) {
      heap.offer(list);
    }
    
    var cur = heap.poll();
    var head = new ListNode(666);
    var headPointer = head;
    
    while (cur != null) {
      headPointer.next = cur;
      headPointer = cur;
      
      if (cur.next != null) {
        heap.offer(cur.next);
      }
      
      cur = heap.poll();
    }
    
    return head.next;
  }
}
