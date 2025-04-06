package com.github.daddyingrave.leetcode.arrays;

class MyHashMap {
  private final Entry TOMBSTONE = new Entry(Integer.MIN_VALUE, Integer.MIN_VALUE);
  private Entry[] backingArray = new Entry[10];
  private int size;

  public MyHashMap() {
  }

  public void put(int key, int value) {
    if (((double) size / backingArray.length) > 0.6) {
      this.reallocate();
    }

    int index = Math.floorMod(key, backingArray.length);
    int startIndex = index;

    Entry entry = new Entry(key, value);
    do {
      if (backingArray[index] == null || TOMBSTONE.equals(backingArray[index])) {
        backingArray[index] = entry;
        size++;
        return;
      } 
      else if (backingArray[index].key == key) {
        backingArray[index] = entry;
        return;
      } 
      else {
        index = (index + 1) % backingArray.length;
      }
    } while (index != startIndex);
  }

  public int get(int key) {
    if (size == 0) {
      return -1;
    }

    int index = Math.floorMod(key, backingArray.length);
    int startIndex = index;

    do {
      if (backingArray[index] == null) {
        return -1;
      }

      if (!TOMBSTONE.equals(backingArray[index]) && backingArray[index].key == key) {
        return backingArray[index].value;
      }

      index = (index + 1) % backingArray.length;
    } while (index != startIndex);

    return -1;
  }

  public void remove(int key) {
    if (size == 0) {
      return;
    }

    int index = Math.floorMod(key, backingArray.length);
    int startIndex = index;

    do {
      if (backingArray[index] == null) {
        return;
      }

      if (!TOMBSTONE.equals(backingArray[index]) && backingArray[index].key == key) {
        backingArray[index] = TOMBSTONE;
        size--;
        return;
      }

      index = (index + 1) % backingArray.length;
    } while (index != startIndex);
  }

  private void reallocate() {
    var newBackingArray = new Entry[backingArray.length * 2];

    for (var entry : this.backingArray) {
      if (entry != null && !TOMBSTONE.equals(entry)) {
        int index = Math.floorMod(entry.key, newBackingArray.length);
        while (newBackingArray[index] != null) {
          index = (index + 1) % newBackingArray.length;
        }
        newBackingArray[index] = entry;
      }
    }

    this.backingArray = newBackingArray;
  }

  record Entry(int key, int value) {
  }
}
