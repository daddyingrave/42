package com.github.andreyelagin.backtobackswe.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {

  @Test
  void enqueue() {
    var queue = new CircularQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    queue.enqueue(3);
    
    assertEquals(12, queue.size());
  }

  @Test
  void dequeue() {
    var queue = new CircularQueue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    
    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.dequeue());
    assertEquals(3, queue.dequeue());

    assertEquals(0, queue.size());
  }
}