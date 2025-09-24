package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class CarFleet853Test {
  class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
      record CarRide(int position, int speed, double timeToTarget) {
      }

      CarRide[] cars = new CarRide[position.length];
      for (int i = 0; i < position.length; i++) {
        cars[i] = new CarRide(position[i], speed[i], (double) (target - position[i]) / speed[i]);
      }
      Arrays.sort(cars, Comparator.comparingInt(CarRide::position).reversed());

      var stack = new Stack<CarRide>();
      for (CarRide car : cars) {
        stack.push(car);
        if (stack.size() >= 2 &&
            stack.peek().timeToTarget <= stack.get(stack.size() - 2).timeToTarget) {
          stack.pop();
        }
      }

      return stack.size();
    }
  }

  @Test
  void test() {

  }
}
