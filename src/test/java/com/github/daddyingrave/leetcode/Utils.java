package com.github.daddyingrave.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {
  public static <T extends Number> Set<T> arrayBoxedToSet(T[] array) {
    return Arrays.stream(array).collect(Collectors.toSet());
  }

  public static Set<Integer> arrayToSet(int[] array) {
    return Arrays.stream(array).boxed().collect(Collectors.toSet());
  }
}
