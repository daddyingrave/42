package com.github.daddyingrave.backtobackswe.stacksandqueues;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CircularQueue {
  private int[] state = new int[10];

  private int head;
  private int tail;
  private int size;

  public CircularQueue() {
  }

  public void enqueue(int x) {
    if (size == state.length) {
      resize();
    }
    state[tail] = x;

    tail = (tail + 1);
    size++;
  }

  public int dequeue() {
    if (size == 0) {
      throw new NoSuchElementException("Queue is empty.");
    }

    var item = state[head];
    head = (head + 1);
    size--;

    return item;
  }

  public int size() {
    return size;
  }

  private void resize() {
    var newArr = new int[size * 3 / 2];
    System.arraycopy(state, head, newArr, 0, state.length - head);
    state = newArr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CircularQueue that = (CircularQueue) o;
    return size == that.size && Arrays.equals(state, that.state);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result + Arrays.hashCode(state);
    return result;
  }
}
