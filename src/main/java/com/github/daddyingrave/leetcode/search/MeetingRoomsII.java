package com.github.daddyingrave.leetcode.search;

import java.util.Arrays;

public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    
    int[] starts = new int[intervals.length];
    int[] ends = new int[intervals.length];

    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }

    Arrays.sort(starts);
    Arrays.sort(ends);
    
    int startPointer = 0;
    int endPointer = 0;
    int roomsRequired = 0;

    while (startPointer < intervals.length) {
      if (starts[startPointer] >= ends[endPointer]) {
        endPointer++;
        roomsRequired--;
      }
      
      roomsRequired++;
      startPointer++;
    }
    
    return roomsRequired;
  }
}
