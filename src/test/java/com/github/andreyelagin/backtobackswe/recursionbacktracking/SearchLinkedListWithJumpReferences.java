package com.github.andreyelagin.backtobackswe.recursionbacktracking;

public class SearchLinkedListWithJumpReferences {
  public void setJumpReferences(ListNodeJump node) {
    Integer order = 0;
    traverseAndSet(node, order);
  }

  private void traverseAndSet(ListNodeJump node, Integer order) {
    if (node == null || node.val == -1) {
      return;
    }
    
    node.val = order++;
    
    traverseAndSet(node.jump, order);
    traverseAndSet(node.next, order);
  }

  private static class ListNodeJump {
    public int val;
    public ListNodeJump next;
    public ListNodeJump jump;

    public ListNodeJump(int val) {
      this.val = val;
    }
  }
}
