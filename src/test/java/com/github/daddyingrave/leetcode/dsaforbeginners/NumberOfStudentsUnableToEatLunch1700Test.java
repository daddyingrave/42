package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class NumberOfStudentsUnableToEatLunch1700Test {
  public int countStudents(int[] students, int[] sandwiches) {
    Queue<Integer> studentsQ = new LinkedList<>();
    for (int student : students) {
      studentsQ.offer(student);
    }

    for (int sandwich : sandwiches) {
      int skipCount = 0;
      while (skipCount < sandwiches.length && studentsQ.peek() != sandwich) {
        studentsQ.offer(studentsQ.poll());
        skipCount++;
      }

      if (studentsQ.peek() == sandwich) {
        studentsQ.poll();
      } else {
        break;
      }
    }


    return studentsQ.size();
  }

  @Test
  void test() {
    assertEquals(0, countStudents(new int[]{1, 1, 0, 0}, new int[]{0, 1, 0, 1}));
    assertEquals(3, countStudents(new int[]{1, 1, 1, 0, 0, 1}, new int[]{1, 0, 0, 0, 1, 1}));
  }
}
