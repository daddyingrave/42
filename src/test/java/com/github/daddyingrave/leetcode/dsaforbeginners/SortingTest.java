package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortingTest {
  public void insertionSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      // Store the current element (nums[i]) as the 'key'.
      // This is the element we want to insert into the sorted subarray.
      int key = nums[i];

      // 'j' is used to traverse the sorted portion of the array (nums[0...i-1])
      // from right to left, starting just before the 'key' element.
      int j = i - 1;

      // Inner loop: Compare 'key' with elements in the sorted subarray.
      // Shift elements that are greater than 'key' one position to the right.
      // This creates a "hole" where 'key' will eventually be placed.
      while (j >= 0 && nums[j] > key) {
        // Shift nums[j] to nums[j+1]
        nums[j + 1] = nums[j];
        // Move to the left to compare with the next element
        j--;
      }

      // After the while loop, 'j+1' is the correct position for 'key'.
      // Either j became -1 (meaning key is the smallest element so far),
      // or nums[j] was found to be less than or equal to key.
      nums[j + 1] = key;
    }
  }

  @Test
  void insertionTest() {
    int[] actual = new int[]{4, 5, 3, 2, 1};
    insertionSort(actual);
    assertArrayEquals(new int[]{1, 2, 3, 4, 5}, actual);
  }

  @Test
  void insertionTest2() {
    int[] actual = new int[]{5, 4, 3, 2,};
    insertionSort(actual);
    assertArrayEquals(new int[]{2, 3, 4, 5}, actual);
  }
}
