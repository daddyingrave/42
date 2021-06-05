package com.github.andreyelagin.backtobackswe.searching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntersectionOf2SortedArraysTest {

  IntersectionOf2SortedArrays intersection = new IntersectionOf2SortedArrays();

  @Test
  void intersection() {
    int[] left = new int[]{1, 2, 3, 4, 5};
    int[] right = new int[]{1, 2};

    assertArrayEquals(new int[]{1, 2}, intersection.intersection(left, right));
  }

  @Test
  void intersection2() {
    int[] left = new int[]{1, 2, 2, 3};
    int[] right = new int[]{1, 1, 4};

    assertArrayEquals(new int[]{1}, intersection.intersection(left, right));
  }

  @Test
  void intersection3() {
    int[] left = new int[]{1, 2, 3, 4, 4, 5};
    int[] right = new int[]{4, 4, 5};

    assertArrayEquals(new int[]{4, 5}, intersection.intersection(left, right));
  }

  @Test
  void intersection4() {
    int[] left = new int[]{38, 42, 52, 90, 92, 99, 100, 141, 142, 158, 180, 247, 270, 294, 298,
        300, 306, 316, 321, 337, 391, 408, 432, 448, 459, 498, 537, 555, 564, 574, 699, 699, 718,
        726, 758, 783, 839, 842, 868, 910, 940, 946, 983, 984, 996};
    int[] right = new int[]{23, 36, 38, 48, 59, 67, 100, 102, 115, 140, 173, 219, 242, 266, 288,
        309, 315, 346, 375, 399, 427, 429, 441, 483, 520, 535, 578, 587, 608, 623, 637, 658, 664,
        665, 677, 688, 730, 742, 770, 773, 780, 787, 797, 826, 843, 879, 910, 913, 942, 966};

    assertArrayEquals(new int[]{38, 100, 910}, intersection.intersection(left, right));
  }
}