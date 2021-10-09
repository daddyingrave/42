package com.github.andreyelagin.leetcode.math;

import java.util.Arrays;

public class RobotBoundedInCircle {
  public boolean isRobotBounded(String instructions) {
    var currentDirection = Direction.NORTH;
    String[] cmds = instructions.split("");
    int[] lastCoordinate = new int[]{0, 0};
      for (String cmd :cmds) {
        switch (cmd) {
          case "L":
            currentDirection = nextDirection(currentDirection, "L");
            break;
          case "R":
            currentDirection = nextDirection(currentDirection, "R");
            break;
          case "G":
            switch (currentDirection.ordinal()) {
              case 0:
                lastCoordinate[0]++;
                break;
              case 1:
                lastCoordinate[1]++;
                break;
              case 2:
                lastCoordinate[0]--;
                break;
              case 3:
                lastCoordinate[1]--;
                break;
            }
            break;
        }
      }
    
    return Arrays.equals(lastCoordinate, new int[]{0, 0}) || currentDirection != Direction.NORTH;
  }
  
  private Direction nextDirection(Direction current, String cmd) {
    Direction next;
    switch (cmd) {
      case "L":
        next = current.move(-1);
        break;
      case "R":
        next = current.move(1);
        break;
      default:
        throw new RuntimeException();
    };
    return next;
  }
  
  enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;
    public Direction move(int next) {
      next += this.ordinal();
      if (next < 0) {
        return WEST;
      } else if (next > WEST.ordinal()) {
        return NORTH;
      } else {
        return Direction.values()[next];
      }
    }
  }
}
