package com.github.andreyelagin.backtobackswe.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueMaxTest {

  @Test
  void max() {
    var queue = new QueueMax();
    
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(-11);
    
    assertEquals(2, queue.max());
    
    queue.enqueue(-12);
    queue.enqueue(100);

    assertEquals(100, queue.max());
    
    assertEquals(1, queue.dequeue());
    assertEquals(2, queue.dequeue());
    assertEquals(-11, queue.dequeue());

    assertEquals(100, queue.max());
  }
}