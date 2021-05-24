package com.github.andreyelagin.backtobackswe.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackQueueTest {

  @Test
  void add() {
    var queue = new StackQueue();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    assertEquals(4, queue.size());
  }

  @Test
  void poll() {
    var queue = new StackQueue();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    assertEquals(4, queue.size());
    assertEquals(1, queue.poll());
    assertEquals(3, queue.size());
    assertEquals(2, queue.poll());
    assertEquals(2, queue.size());
    assertEquals(3, queue.poll());
    assertEquals(1, queue.size());
    assertEquals(4, queue.poll());
    assertEquals(0, queue.size());
  }

  @Test
  void isEmpty() {
    var queue = new StackQueue();

    assertTrue(queue.isEmpty());

    queue.add(1);
    queue.add(4);

    assertFalse(queue.isEmpty());

    queue.poll();
    queue.poll();

    assertTrue(queue.isEmpty());
  }
}