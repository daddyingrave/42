package com.github.daddyingrave.backtobackswe.arrays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindAllDuplicatesInArrayTest {

  FindAllDuplicatesInArray findAllDuplicatesInArray = new FindAllDuplicatesInArray();

  @Test
  void findDuplicates() {
    assertEquals(
        List.of(2, 3), 
        findAllDuplicatesInArray.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1})
    );
    assertEquals(
        List.of(1),
        findAllDuplicatesInArray.findDuplicates(new int[]{1,1,2})
    );
    assertEquals(
        List.of(),
        findAllDuplicatesInArray.findDuplicates(new int[]{1})
    );
  }
}