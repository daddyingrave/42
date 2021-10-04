package com.github.andreyelagin.leetcode.arrays;

public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int distance = height.length - 1;
    Point leftMax = new Point(height[left], left);
    Point rightMax = new Point(height[right], right);
    int maxArea = 0;

    while (left <= right) {
      int leftHeight = height[left];
      int rightHeight = height[right];
      int newArea = Math.min(leftHeight, rightHeight) * (right - left);
      
      if (leftMax.height < leftHeight) {
        leftMax = new Point(leftHeight, left);
        newArea = Math.max(
            newArea, 
            (Math.min(leftMax.height, rightMax.height) * (rightMax.coordinate - leftMax.coordinate))
        );
      }

      if (rightMax.height < rightHeight) {
        rightMax = new Point(rightHeight, right);
        newArea = Math.max(
            newArea,
            (Math.min(leftMax.height, rightMax.height) * (rightMax.coordinate - leftMax.coordinate))
        );
      }
      
      left++;
      right--;
      maxArea = Math.max(maxArea, newArea);
    }

    return maxArea;
  }

  private static class Point {
    int height;
    int coordinate;

    public Point(int height, int coordinate) {
      this.height = height;
      this.coordinate = coordinate;
    }
  }
}
