package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableTest {
  class HashTable {
    Node[] data;
    int size;
    int capacity;

    public HashTable(int capacity) {
      this.capacity = capacity;
      data = new Node[capacity];
    }

    public void insert(int key, int value) {
      int index = key % this.capacity;
      Node node = this.data[index];
      if (node == null) {
        this.data[index] = new Node(key, value);
      } else {
        var cur = node;
        boolean exist = false;
        while (cur.next != null) {
          if (cur.key == key) {
            cur.val = value;
            exist = true;
            break;
          }

          cur = cur.next;
        }
        if (cur.key == key) {
          cur.val = value;
          exist = true;
        }

        if (!exist) {
          cur.next = new Node(key, value);
        }
      }

      this.size++;

      if ((double) this.size / this.capacity >= 0.5) {
        resize();
      }
    }

    public int get(int key) {
      int index = key % this.capacity;
      Node node = this.data[index];
      if (node != null) {
        var cur = node;
        while (cur != null && cur.key != key) {
          cur = cur.next;
        }

        if (cur != null) {
          return cur.val;
        } else {
          return -1;
        }
      } else {
        return -1;
      }
    }

    public boolean remove(int key) {
      int index = key % this.capacity;
      var node = this.data[index];
      if (node != null) {
        Node prev = null;
        var cur = node;
        while (cur != null && cur.key != key) {
          prev = cur;
          cur = cur.next;
        }

        if (cur == null) {
          return false;
        }

        if (prev == null && cur.next == null) {
          this.data[index] = null;
        } else if (prev != null) {
          prev.next = cur.next;
        } else {
          this.data[index] = cur.next;
          cur.next = null;
        }

        this.size--;
        return true;
      } else {
        return false;
      }
    }

    public int getSize() {
      return this.size;
    }

    public int getCapacity() {
      return this.capacity;
    }

    public void resize() {
      int newCapacity = this.capacity * 2;
      var newData = new Node[newCapacity];
      for (Node node : data) {
        if (node != null) {
          var cur = node;
          while (cur != null) {
            int index = cur.key % newCapacity;
            if (newData[index] != null) {
              var curInsert = newData[index];
              while (curInsert.next != null) {
                curInsert = curInsert.next;
              }

              curInsert.next = new Node(cur.key, cur.val);
            } else {
              newData[index] = new Node(cur.key, cur.val);
            }

            cur = cur.next;
          }
        }
      }

      this.data = newData;
      this.capacity = newCapacity;
    }

    class Node {
      int key;
      int val;
      Node next;

      Node(int key, int val) {
        this.key = key;
        this.val = val;
      }
    }
  }

  @Test
  void test() {
    var table = new HashTable(2);
    assertEquals(2, table.getCapacity());
    table.insert(6, 7);
    assertEquals(4, table.getCapacity());
    table.insert(1, 2);
    assertEquals(8, table.getCapacity());
    table.insert(3, 4);
    assertEquals(8, table.getCapacity());
    assertEquals(3, table.getSize());
  }

  @Test
  void test2() {
    var table = new HashTable(4);
    table.insert(1, 2);
    assertEquals(2, table.get(1));
    table.insert(1, 3);
    assertEquals(3, table.get(1));
  }

  @Test
  void test3() {
    var table = new HashTable(4);
    table.insert(4, 4);
    assertEquals(4, table.get(4));
    table.insert(4, 5);
    assertEquals(5, table.get(4));
  }
}
