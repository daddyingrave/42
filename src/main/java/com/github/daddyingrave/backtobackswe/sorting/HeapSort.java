package com.github.daddyingrave.backtobackswe.sorting;

import java.util.Arrays;

public class HeapSort {
  public int[] heapsort(int[] arr) {
    var copy = Arrays.copyOf(arr, arr.length);

    buildHeap(copy);
    placement(copy);

    return copy;
  }

  private void buildHeap(int[] arr) {
    int mid = arr.length / 2;
    int current = mid;
    int heapSize = arr.length;

    while (current >= 0) {
      if (hasLeft(current, heapSize) && hasRight(current, heapSize)) {
        if (left(arr, current) > arr[current] || right(arr, current) > arr[current]) {
          int maxChildIndex = maxChildIndex(arr, current);
          swap(arr, current, maxChildIndex);
          current = maxChildIndex;
        } else {
          current = --mid;
        }
      } else if (hasLeft(current, heapSize)) {
        if (left(arr, current) > arr[current]) {
          swap(arr, leftIndex(current), current);
          current = leftIndex(current);
        } else {
          current = --mid;
        }
      } else {
        current = --mid;
      }
    }
  }

  private void placement(int[] heap) {
    int heapSize = heap.length;
    while (heapSize > 0) {
      swap(heap, 0, --heapSize);
      int parent = 0;
      while (hasLeft(parent, heapSize)) {
        if (hasRight(parent, heapSize)) {
          if (left(heap, parent) > heap[parent] || right(heap, parent) > heap[parent]) {
            int maxChildIndex = maxChildIndex(heap, parent);
            swap(heap, parent, maxChildIndex);
            parent = maxChildIndex;
          } else {
            break;
          }
        } else if (left(heap, parent) > heap[parent]) {
          swap(heap, parent, leftIndex(parent));
          parent = leftIndex(parent);
        } else {
          break;
        }
      }
    }
  }

  private void swap(int[] arr, int l, int r) {
    int temp = arr[l];
    arr[l] = arr[r];
    arr[r] = temp;
  }

  private int maxChildIndex(int[] arr, int parentIndex) {
    int leftChild = left(arr, parentIndex);
    int rightChild = right(arr, parentIndex);
    if (leftChild >= rightChild) {
      return leftIndex(parentIndex);
    } else {
      return rightIndex(parentIndex);
    }
  }

  private int left(int[] arr, int parentIndex) {
    return arr[leftIndex(parentIndex)];
  }

  private int right(int[] arr, int parentIndex) {
    return arr[rightIndex(parentIndex)];
  }

  private boolean hasLeft(int parentIndex, int heapSize) {
    return leftIndex(parentIndex) < heapSize;
  }

  private boolean hasRight(int parentIndex, int heapSize) {
    return rightIndex(parentIndex) < heapSize;
  }

  private int leftIndex(int parentIndex) {
    return parentIndex * 2 + 1;
  }

  private int rightIndex(int parentIndex) {
    return parentIndex * 2 + 2;
  }
}
