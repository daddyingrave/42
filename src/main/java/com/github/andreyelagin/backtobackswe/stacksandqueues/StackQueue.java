package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class StackQueue {
  private final Stack<Integer> front = new Stack<>();
  private final Stack<Integer> rear = new Stack<>();
  private int size = 0;
  
  public void add(int value) {
    rear.push(value);
    size++;
  }

  public int poll() {
    if (front.isEmpty()) {
      if (rear.isEmpty()) {
        throw new NoSuchElementException();
      }
      while (!rear.isEmpty()) {
        front.push(rear.pop());
      }
    }
    size--;
    return front.pop();
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return front.isEmpty() && rear.isEmpty();
  }
}
