package com.github.daddyingrave.leetcode.arrays;

// 705
public class MyHashSet {
  private final Integer TOMBSTONE = Integer.MIN_VALUE;
  private Integer[] backingArray = new Integer[10];
  private int size;

  public MyHashSet() {
  }

  public void add(int key) {
    if (((double) size / backingArray.length) > 0.6) {
      this.reallocate();
    }

    int index = Math.floorMod(key, backingArray.length);
    while (true) {
      if (backingArray[index] == null || TOMBSTONE.equals(backingArray[index])) {
        backingArray[index] = key;
        break;
      } else if (backingArray[index] == key) {
        return;
      } else {
        index = (index + 1) % backingArray.length;
      }
    }

    size++;
  }

  public void remove(int key) {
    int index = Math.floorMod(key, backingArray.length);
    while (backingArray[index] != null && !TOMBSTONE.equals(backingArray[index])) {
      if (backingArray[index] == key) {
        backingArray[index] = TOMBSTONE;
        size--;
        return;
      } else {
        index = (index + 1) % backingArray.length;
      }
    }
  }

  public boolean contains(int key) {
    int index = Math.floorMod(key, backingArray.length);
    int startIndex = index;
    while (backingArray[index] != null) {
      if (!TOMBSTONE.equals(backingArray[index]) && backingArray[index] == key) {
        return true;
      }
      index = (index + 1) % backingArray.length;
      // If we've gone all the way around the array, the element is not present
      if (index == startIndex) {
        break;
      }
    }

    return false;
  }

  private void reallocate() {
    var newBackingArray = new Integer[size * 2];
    for (Integer i : this.backingArray) {
      if (i != null && !TOMBSTONE.equals(i)) {
        int index = Math.floorMod(i, newBackingArray.length);
        while (newBackingArray[index] != null) {
          index = (index + 1) % newBackingArray.length;
        }
        newBackingArray[index] = i;
      }
    }

    this.backingArray = newBackingArray;
  }
}
