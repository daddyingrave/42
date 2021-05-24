package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.*;

public class QueueMax {
  private final Queue<Integer> state = new LinkedList<>();
  private final Deque<Integer> cache = new LinkedList<>();
  
  public void enqueue(int x) {
    state.add(x);
    
    while (!cache.isEmpty() && cache.peek() < x) {
      cache.removeLast();
    }
    cache.addLast(x);
  }
  
  public int dequeue() {
    if (state.isEmpty()) {
      throw new NoSuchElementException();
    }
    
    var first = state.poll();

    if (Objects.equals(cache.peekFirst(), first)) {
      cache.removeFirst();
    }
    
    return first;
  }
  
  public int max() {
    if (cache.isEmpty()) {
      throw new NoSuchElementException();
    }
    return cache.peek();
  }
}
