package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import java.util.Objects;
import java.util.Stack;

public class SearchLinkedListWithJumpReferences {
  public void setJumpReferences(ListNodeJump node) {
    Int order = new Int(0);
    traverseAndSet(node, order);
  }

  private void traverseAndSet(ListNodeJump node, Int order) {
    if (node == null || node.val != -1) {
      return;
    }

    node.val = order.val;
    order.val += 1;

    traverseAndSet(node.jump, order);
    traverseAndSet(node.next, order);
  }

  public void setJumpReferencesIterative(ListNodeJump node) {
    int order = 0;
    var stack = new Stack<ListNodeJump>();
    stack.push(node);

    while (!stack.isEmpty()) {
      var cur = stack.pop();
      
      if (cur.val == -1) {
        cur.val = order++;

        if (cur.next != null) {
          stack.push(cur.next);
        }
        if (cur.jump != null) {
          stack.push(cur.jump);
        }
      }
    }
  }

  static class Int {
    int val;

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Int anInt = (Int) o;
      return val == anInt.val;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }

    public Int(int val) {
      this.val = val;
    }
  }

  static class ListNodeJump {
    public int val;
    public ListNodeJump next;
    public ListNodeJump jump;

    public ListNodeJump(int val) {
      this.val = val;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ListNodeJump that = (ListNodeJump) o;

      var thisCur = this;
      var thatCur = that;

      while (thisCur != null && thatCur != null) {
        if (thisCur.val != thatCur.val) {
          return false;
        }
        thisCur = thisCur.next;
        thatCur = thatCur.next;
      }

      return thisCur == null && thatCur == null;
    }

    @Override
    public int hashCode() {
      return Objects.hash(val);
    }

    @Override
    public String toString() {
      var sb = new StringBuilder();
      var cur = this;

      int stupidCounter = 0;
      while (cur != null) {
        sb.append(cur.val).append(" ");
        cur = cur.next;
      }

      return sb.toString();
    }
  }
}
