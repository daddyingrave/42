package com.github.daddyingrave.backtobackswe.stacksandqueues;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputeBuildingsWithSunsetViewTest {

  ComputeBuildingsWithSunsetView view = new ComputeBuildingsWithSunsetView();

  @Test
  void getBuildingsWithAView() {
    assertEquals(List.of(0, 1, 2, 3, 4), view.getBuildingsWithAView(new int[]{11, 12, 13, 14, 15}));
    assertEquals(List.of(0, 2, 4), view.getBuildingsWithAView(new int[]{7, 4, 8, 2, 9}));
    assertEquals(List.of(0, 1), view.getBuildingsWithAView(new int[]{0, 1, 0, 1, 0}));
  }
}