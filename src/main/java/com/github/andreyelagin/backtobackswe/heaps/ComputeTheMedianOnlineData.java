package com.github.andreyelagin.backtobackswe.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComputeTheMedianOnlineData {

  private final PriorityQueue<Integer> less = new PriorityQueue<>(Comparator.reverseOrder());
  private final PriorityQueue<Integer> more = new PriorityQueue<>();
  
  public double median() {
    if (less.size() == more.size()) {
      return 0.5 * (less.peek() + more.peek());
    } else {
      return more.peek();
    }
  }
  
  public void insert(int val) {
    if (more.isEmpty()) {
      more.offer(val);
    } else {
      if (val < more.peek()) {
        less.offer(val);
      } else {
        more.offer(val);
      }
    }

    rebalance();
  }
  
  private void rebalance() {
    if (more.size() >= less.size() + 2) {
      less.add(more.poll());
    } else if (less.size() >= more.size() + 1) {
      more.add(less.poll());
    }
//    var heapDiff = Math.abs(less.size() - more.size());
//    if (heapDiff > 1) {
//      PriorityQueue<Integer> large;
//      PriorityQueue<Integer> small;
//      if (less.size() > more.size()) {
//        large = less;
//        small = more;
//      } else {
//        large = more;
//        small = less;
//      }
//      while (heapDiff > 1) {
//        small.offer(large.poll());
//        heapDiff--;
//      }
//    }
  }
}
