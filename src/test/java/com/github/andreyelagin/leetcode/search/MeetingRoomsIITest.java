package com.github.andreyelagin.leetcode.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsIITest {

  MeetingRoomsII meetingRooms = new MeetingRoomsII();

  @Test
  void minMeetingRooms() {
    assertEquals(
        2,
        meetingRooms.minMeetingRooms(
            new int[][]{
                new int[]{0, 30},
                new int[]{5, 10},
                new int[]{15, 20}
            }
        )
    );
    assertEquals(
        1,
        meetingRooms.minMeetingRooms(
            new int[][]{
                new int[]{7, 10},
                new int[]{2, 4}
            }
        )
    );
    assertEquals(
        2,
        meetingRooms.minMeetingRooms(
            new int[][]{
                new int[]{9, 10},
                new int[]{4, 9},
                new int[]{4, 17}
            }
        )
    );
  }
}