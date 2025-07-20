package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

  class MinHeap {
    List<Integer> heap = new ArrayList<>();

    public MinHeap() {
      heap.add(0);
    }

    public void push(int val) {
      heap.add(val);

      int insertionIndex = heap.size() - 1;
      int parentIndex = insertionIndex / 2;

      while (parentIndex > 0 && heap.get(parentIndex) > val) {
        swap(parentIndex, insertionIndex);
        insertionIndex = parentIndex;
        parentIndex = parentIndex / 2;
      }
    }

    public Integer pop() {
      if (heap.size() == 1) {
        return -1;
      }
      if (heap.size() == 2) {
        return heap.remove(1);
      }

      int top = top();
      int lastIndex = heap.size() - 1;
      int newIndex = 1;
      heap.set(newIndex, heap.get(lastIndex));
      heap.remove(lastIndex);

      bubleDown(newIndex);

      return top;
    }

    public Integer top() {
      return heap.size() == 1 ? -1 : heap.get(1);
    }

    public void heapify(List<Integer> nums) {
      heap.addAll(nums);

      if (heap.size() <= 2) {
        return;
      }

      int index = heap.size() / 2;
      while (index >= 1) {
        bubleDown(index);
        index--;
      }
    }

    void swap(int left, int right) {
      int tmp = heap.get(left);
      heap.set(left, heap.get(right));
      heap.set(right, tmp);
    }

    void bubleDown(int i) {
      while (i * 2 < heap.size()) {
        if (i * 2 + 1 < heap.size() && heap.get(i * 2) > heap.get(i * 2 + 1)) {
          swap(i, i * 2 + 1);
          i = i * 2 + 1;
        } else if (heap.get(i * 2) < heap.get(i)) {
          swap(i, i * 2);
          i = i * 2;
        } else {
          break;
        }
      }
    }
  }

  @Test
  void test() {
    var heap = new MinHeap();
    heap.push(6);
    assertEquals(6, heap.top());
    heap.push(4);
    assertEquals(4, heap.top());
    heap.push(3);
    assertEquals(3, heap.top());
    heap.push(18);
    assertEquals(3, heap.top());
    heap.push(1);
    assertEquals(1, heap.top());

    assertEquals(1, heap.pop());
    assertEquals(3, heap.top());

    assertEquals(3, heap.pop());
    assertEquals(4, heap.top());
  }

  @Test
  void test2() {
    var heap = new MinHeap();
    heap.heapify(List.of(5, 4, 3, 2, 1));
    assertEquals(1, heap.pop());
  }

  @Test
  void test3() {
    var heap = new MinHeap();
    assertEquals(-1, heap.top());
    heap.push(1);
    assertEquals(1, heap.top());
    assertEquals(1, heap.pop());
    assertEquals(-1, heap.pop());
  }

  @Test
  void test4() {
    var heap = new MinHeap();
    heap.push(5);
    heap.push(2);
    heap.push(1);
    heap.push(10);
    assertEquals(1, heap.top());
    assertEquals(1, heap.pop());

    assertEquals(2, heap.top());
    assertEquals(2, heap.pop());

    assertEquals(5, heap.top());
    assertEquals(5, heap.pop());

    assertEquals(10, heap.top());
    assertEquals(10, heap.pop());
  }
}
