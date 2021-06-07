package com.github.andreyelagin.backtobackswe.heaps;

import java.util.Arrays;

public class MaxHeap {
  private int[] arr;
  private int size;

  public MaxHeap(int size) {
    this.arr = new int[size];
    this.size = 0;
  }

  public void insert(int val) {
    expand();
    arr[size++] = val;
    bubble();
  }
  
  private void bubble() {
    int index = size - 1;
    while (hasParent(index) && arr[index] < parent(index)) {
      int parentIndex = parentIndex(index);
      swap(parentIndex, index);
      index = parentIndex;
    }
  }
  
  public int remove() {
    if (empty()) {
      throw new RuntimeException("Remove impossible. Empty heap");
    }
    
    return 0;
  }
  
  public int peek() {
    if (empty()) {
      throw new RuntimeException("Peek impossible. Empty heap");
    }
    return 0;
  }
  
  public boolean empty() {
    return size == 0;
  }
  
  private void expand() {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, size * 2);
    }
  }
  
  private void swap(int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
  
  private int leftChildIndex(int parentIndex) {
    return arr[2 * parentIndex + 1];
  }

  private int rightChildIndex(int parentIndex) {
    return arr[2 * parentIndex + 2];
  }
  
  private int parentIndex(int childIndex) {
    return arr[(childIndex - 1) / 2];
  }
  
  private boolean hasLeftChild(int parentIndex) {
    return leftChildIndex(parentIndex) < size;
  }
  
  private boolean hasRightChild(int parentIndex) {
    return rightChildIndex(parentIndex) < size;
  }
  
  private boolean hasParent(int childIndex) {
    return childIndex != 0 && parentIndex(childIndex) >= 0;
  }
  
  private int leftChild(int index) {
    return arr[leftChildIndex(index)];
  }
  
  private int rightChild(int index) {
    return arr[rightChildIndex(index)];
  }
  
  private int parent(int index) {
    return arr[parentIndex(index)];
  }
}
