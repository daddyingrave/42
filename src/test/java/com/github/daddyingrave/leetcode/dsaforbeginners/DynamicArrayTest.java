package com.github.daddyingrave.leetcode.dsaforbeginners;

public class DynamicArrayTest {
  static class DynamicArray {
    private Integer[] data;
    private int size;

    public DynamicArray(int capacity) {
      this.data = new Integer[capacity];
    }

    public int get(int i) {
      return this.data[i];
    }

    public void set(int i, int n) {
      this.data[i] = n;
    }

    public void pushback(int n) {
      if (this.size == this.data.length) {
        this.resize();
      }
      this.data[size++] = n;
    }

    public int popback() {
      int element = this.data[this.size - 1];
      this.data[--this.size] = null;
      return element;
    }

    private void resize() {
      Integer[] newData = new Integer[this.data.length * 2];
      System.arraycopy(this.data, 0, newData, 0, this.data.length);
      this.data = newData;
    }

    public int getSize() {
      return this.size;
    }

    public int getCapacity() {
      return this.data.length;
    }
  }
}
