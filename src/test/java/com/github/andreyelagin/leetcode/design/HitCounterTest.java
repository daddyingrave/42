package com.github.andreyelagin.leetcode.design;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HitCounterTest {

  @Test
  void hit() {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);
    hitCounter.hit(2);
    hitCounter.hit(3);
    assertEquals(3, hitCounter.getHits(4));
    hitCounter.hit(300);
    assertEquals(4, hitCounter.getHits(300));
    assertEquals(3, hitCounter.getHits(301));
  }

  @Test
  void hit2() {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(1);
    hitCounter.hit(1);
    hitCounter.hit(1);
    hitCounter.hit(300);
    assertEquals(4, hitCounter.getHits(300));
  }

  @Test
  void hit3() {
    HitCounter hitCounter = new HitCounter();
    hitCounter.hit(2);
    hitCounter.hit(3);
    hitCounter.hit(4);
    assertEquals(3, hitCounter.getHits(300));
    assertEquals(3, hitCounter.getHits(301));
    assertEquals(2, hitCounter.getHits(302));
    assertEquals(1, hitCounter.getHits(303));
    assertEquals(0, hitCounter.getHits(304));
    hitCounter.hit(300);
  }
}