package com.github.andreyelagin.backtobackswe.tree;

import java.util.HashMap;
import java.util.Map;

public class TreeReconstruction {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (inorder.length == 0) {
      return null;
    }
    var nodeToIndex = new HashMap<Integer, Integer>();

    for (int i = 0; i < inorder.length; i++) {
      nodeToIndex.put(inorder[i], i);
    }

    return buildTree(preorder, inorder, 0, inorder.length - 1, nodeToIndex);
  }

  private int preOrderIndex = 0;

  private TreeNode buildTree(
      int[] pre,
      int[] in,
      int left,
      int right,
      Map<Integer, Integer> inorderNodesToIndex
  ) {
    if (left > right) {
      return null;
    }

    int nodeValue = pre[preOrderIndex++];
    var root = new TreeNode(nodeValue);

    if (left == right) {
      return root;
    }

    var inorderIndex = inorderNodesToIndex.get(nodeValue);

    root.left = buildTree(pre, in, left, inorderIndex - 1, inorderNodesToIndex);
    root.right = buildTree(pre, in, inorderIndex + 1, right, inorderNodesToIndex);

    return root;
  }
}
