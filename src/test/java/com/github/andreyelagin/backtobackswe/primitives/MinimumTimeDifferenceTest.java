package com.github.andreyelagin.backtobackswe.primitives;

import com.github.andreyelagin.backtobackswe.primitives.MinimumTimeDifference;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumTimeDifferenceTest {

  @Test
  void timeDifference() {
    assertEquals(0, MinimumTimeDifference.timeDifference(List.of("00:00", "23:59", "00:00")));
    assertEquals(4, MinimumTimeDifference.timeDifference(List.of("23:59", "00:03", "12:03")));
  }
}