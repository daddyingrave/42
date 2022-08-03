package com.github.daddyingrave.leetcode.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInBinarySearchTreeTest {

  SearchInBinarySearchTree searchInBinarySearchTree = new SearchInBinarySearchTree();

  @Test
  void searchBST() {
    // 4,2,7,1,3
    var given = new TreeNode(4);
    given.left = new TreeNode(2);
    given.left.left = new TreeNode(1);
    given.left.right = new TreeNode(3);
    given.right = new TreeNode(7);

    var expected = new TreeNode(2);
    expected.left = new TreeNode(1);
    expected.right = new TreeNode(3);

    assertEquals(expected, searchInBinarySearchTree.searchBST(given, 2));
  }
}