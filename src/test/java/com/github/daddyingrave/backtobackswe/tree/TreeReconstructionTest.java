package com.github.daddyingrave.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeReconstructionTest {

  TreeReconstruction reconstruction = new TreeReconstruction();

  @Test
  void buildTree() {
    var root = new TreeNode(7);
    var node2 = new TreeNode(1);
    var node3 = new TreeNode(12);
    var node4 = new TreeNode(15);
    var node5 = new TreeNode(3);

    root.left = node2;
    root.right = node3;

    node3.left = node4;
    node3.right = node5;

    assertEquals(
        root,
        reconstruction.buildTree(
            new int[]{7, 1, 12, 15, 3},
            new int[]{1, 7, 15, 12, 3}
        )
    );
  }

  @Test
  void buildTree2() {
    // 5,1,2,3,4,6
    var root = new TreeNode(5);
    var node2 = new TreeNode(1);
    var node3 = new TreeNode(2);
    var node4 = new TreeNode(3);
    var node5 = new TreeNode(4);
    var node6 = new TreeNode(6);

    root.left = node2;
    root.right = node3;

    node2.left = node4;
    node2.right = node5; 
    
    node3.left = node6;

    assertEquals(
        root,
        reconstruction.buildTree(
            new int[]{5, 1, 3, 4, 2, 6},
            new int[]{3, 1, 4, 5, 6, 2}
        )
    );
  }
}