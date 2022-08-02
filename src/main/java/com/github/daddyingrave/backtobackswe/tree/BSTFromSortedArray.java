package com.github.daddyingrave.backtobackswe.tree;

public class BSTFromSortedArray {
  public TreeNode sortedArrayToBST(int[] nums) {
    return buildBst(nums, 0, nums.length);
  }

  private TreeNode buildBst(int[] nums, int left, int right) {
    if (left >= right) {
      return null;
    }
    
    int middle = left + ((right - left) / 2);
    var root = new TreeNode(nums[middle]);

    root.left = buildBst(nums, left, middle);
    root.right = buildBst(nums, middle + 1, right);
    
    return root;
  }
}
