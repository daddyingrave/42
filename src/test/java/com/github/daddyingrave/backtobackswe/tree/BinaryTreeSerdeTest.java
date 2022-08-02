package com.github.daddyingrave.backtobackswe.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeSerdeTest {

  BinaryTreeSerde serde = new BinaryTreeSerde();
  
  @Test
  void serialize() {
    var root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    assertEquals("1,2,null,null,3,null,null,", serde.serialize(root));
  }

  @Test
  void deserialize() {
    var root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    assertEquals(root, serde.deserialize("1,2,null,null,3,null,null,"));
  }
}