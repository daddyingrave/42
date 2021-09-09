package com.github.andreyelagin.leetcode.trees;

import java.util.HashMap;

public class ConstructBinaryTreePreorderAndInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    var inorderIndexes = new HashMap<Integer, Integer>();

    for (int i = 0; i < inorder.length; i++) {
      inorderIndexes.put(inorder[i], i);
    }

    return build(0, 0, inorder.length - 1, preorder, inorder, inorderIndexes);
  }

  private TreeNode build(
      int inStart, 
      int preStart, 
      int inEnd,
      int[] preorder, 
      int[] inorder, 
      HashMap<Integer, Integer> inorderIndexes
  ) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
      return null;
    }

    var root = new TreeNode(preorder[preStart]);
    int inIndex = inorderIndexes.get(preorder[preStart]);

    root.left = build(preStart + 1, inStart, inIndex - 1, preorder, inorder, inorderIndexes);
    root.right = build(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder, inorderIndexes);
    
    return root;
  }
}
