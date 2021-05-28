package com.github.andreyelagin.backtobackswe.tree;

public class BSTFromSortedArray {
  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length);
  }

  private TreeNode build(int[] nums, int left, int right) {
    if (left >= right) {
      return null;
    }
    
    int middle = left + ((right - left) / 2);
    var root = new TreeNode(nums[middle]);

    root.left = build(nums, left, middle);
    root.right = build(nums, middle + 1, right);
    
    return root;
  }
}
