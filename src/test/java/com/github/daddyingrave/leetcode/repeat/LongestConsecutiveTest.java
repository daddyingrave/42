package com.github.daddyingrave.leetcode.repeat;

import org.junit.jupiter.api.Test;

class LongestConsecutiveTest {

  class MyHashSet {
    Entry[] data = new Entry[10];
    int size = 0;
    Entry TOMBSTONE = new Entry();

    public MyHashSet() {

    }

    public void add(int key) {
      reallocate();

      var entry = new Entry();
      entry.value = key;
      allocate(entry);
      size++;
    }

    public void remove(int key) {
      int index = getIndex(key);
      if (index != -1) {
        data[index] = TOMBSTONE;
        size--;
      }
    }

    public boolean contains(int key) {
      int index = getIndex(key);
      return index != -1;
    }

    void reallocate() {
      double load = (double) size / data.length;
      if (load > 0.7) {
        var oldData = data;
        data = new Entry[data.length * 2];
        for (Entry old : oldData) {
          if (old != null && old != TOMBSTONE) {
            allocate(old);
          }
        }
      }
    }

    void allocate(Entry key) {
      int index = key.value % data.length;
      while (data[index] != null && data[index] != TOMBSTONE) {
        if (data[index].value == key.value) {
          return;
        }

        index++;
        if (index == data.length) {
          index = 0;
        }
      }

      data[index] = key;
    }

    int getIndex(int key) {
      int index = key % data.length;
      int start = index;
      while (data[index] == null || data[index] == TOMBSTONE || data[index].value != key) {
        index++;

        if (index == data.length) {
          index = 0;
        }
        if (index == start) {
          return -1;
        }
      }

      return index;
    }

    static class Entry {
      int value;
    }
  }

  @Test
  void test() {
    MyHashSet myHashSet = new MyHashSet();
    myHashSet.add(95);
    myHashSet.add(17);
    myHashSet.contains(95);
    myHashSet.contains(26);
    myHashSet.add(70);
    myHashSet.contains(43);
    myHashSet.add(33);
    myHashSet.add(75);
    myHashSet.remove(86);
    myHashSet.add(29);
    myHashSet.contains(39);
    myHashSet.add(74);
    myHashSet.add(56);
    myHashSet.contains(99);
    myHashSet.add(4);
    myHashSet.add(57);
    myHashSet.add(81);
    myHashSet.add(79);
    myHashSet.add(26);
    myHashSet.remove(82);
    myHashSet.add(13);
    myHashSet.add(59);
    myHashSet.add(69);
    myHashSet.remove(98);
    myHashSet.add(45);
    myHashSet.add(53);
    myHashSet.contains(84);
    myHashSet.remove(77);
    myHashSet.remove(89);
    myHashSet.remove(70);
    myHashSet.add(51);
    myHashSet.add(96);
    myHashSet.remove(6);
    myHashSet.add(46);
    myHashSet.add(86);
    myHashSet.contains(96);
    myHashSet.add(87);
    myHashSet.add(37);
    myHashSet.contains(96);
    myHashSet.add(95);
    myHashSet.add(58);
    myHashSet.remove(46);
    myHashSet.add(41);
    myHashSet.add(4);
    myHashSet.add(80);
    myHashSet.add(50);
    myHashSet.add(89);
    myHashSet.remove(17);
    myHashSet.add(4);
    myHashSet.add(14);
    myHashSet.contains(69);
    myHashSet.add(93);
    myHashSet.add(3);
    myHashSet.add(59);
    myHashSet.add(63);
    myHashSet.add(26);
    myHashSet.add(5);
    myHashSet.add(5);
    myHashSet.add(44);
    myHashSet.contains(25);
    myHashSet.add(17);
    myHashSet.remove(46);
    myHashSet.add(69);
    myHashSet.remove(82);
    myHashSet.add(28);
    myHashSet.add(72);
    myHashSet.remove(6);
    myHashSet.contains(43);
    myHashSet.add(11);
    myHashSet.remove(85);
    myHashSet.add(61);
    myHashSet.add(85);
    myHashSet.remove(62);
    myHashSet.add(58);
    myHashSet.add(98);
    myHashSet.remove(70);
    myHashSet.add(13);
    myHashSet.add(48);
    myHashSet.add(91);
    myHashSet.add(96);
    myHashSet.add(87);
    myHashSet.remove(30);
    myHashSet.add(91);
    myHashSet.contains(84);
    myHashSet.add(59);
    myHashSet.add(92);
    myHashSet.add(97);
    myHashSet.add(61);
    myHashSet.add(91);
    myHashSet.add(78);
    myHashSet.add(16);
    myHashSet.add(36);
    myHashSet.add(85);
    myHashSet.add(32);
    myHashSet.add(93);
    myHashSet.add(54);
    myHashSet.add(89);
    myHashSet.add(74);
    myHashSet.add(79);
    myHashSet.add(54);
    myHashSet.remove(79);
    myHashSet.remove(54);
  }
}
