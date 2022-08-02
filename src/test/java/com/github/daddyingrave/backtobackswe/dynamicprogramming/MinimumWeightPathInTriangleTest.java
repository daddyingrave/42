package com.github.daddyingrave.backtobackswe.dynamicprogramming;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWeightPathInTriangleTest {

  MinimumWeightPathInTriangle triangle = new MinimumWeightPathInTriangle();
  
  @Test
  void minimumPathCost() {
    assertEquals(
        11,
        triangle.minimumPathCost(
            List.of(
                List.of(5),
                List.of(1, 6),
                List.of(4, 3, 10),
                List.of(3, 2, 4, 1)
            )
        )
    );
  }
}