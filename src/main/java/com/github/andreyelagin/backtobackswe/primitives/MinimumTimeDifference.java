package com.github.andreyelagin.backtobackswe.primitives;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
  public static int timeDifference(List<String> times) {
    int[] minutes = new int[times.size()];

    for (int i = 0; i < times.size(); i++) {
      minutes[i] = toMinutes(times.get(i));
    }

    Arrays.sort(minutes);

    int currentMin = findMin(minutes[0], minutes[1]);

    for (int i = 2; i < minutes.length; i++) {
      currentMin = Math.min(currentMin, findMin(minutes[i - 1], minutes[i]));
    }

    return Math.min(currentMin, findMin(minutes[0], minutes[minutes.length - 1]));
  }

  private static int toMinutes(String time) {
    String[] split = time.split(":");
    int hours = Integer.parseInt(split[0]);
    int minutes = Integer.parseInt(split[1]);
    return hours * 60 + minutes;
  }

  private static final int DAYTIME_MINUTES = 24 * 60;

  private static int findMin(int left, int right) {
    int diff = Math.abs(left - right);
    int complement = DAYTIME_MINUTES - diff;
    return Math.min(diff, complement);
  }
}
