package com.github.andreyelagin.leetcode.hashtables;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SubdomainVisitCountTest {

  SubdomainVisitCount solution = new SubdomainVisitCount();

  @Test
  void subdomainVisits() {
    var expected = Set.of("9001 leetcode.com", "9001 discuss.leetcode.com", "9001 com");
    assertEquals(expected, new HashSet<>(solution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"})));
  }

  @Test
  void subdomainVisits2() {
    var expected = Set.of(
        "901 mail.com",
        "50 yahoo.com",
        "900 google.mail.com",
        "5 wiki.org",
        "5 org",
        "1 intel.mail.com",
        "951 com"
    );
    assertEquals(
        expected,
        new HashSet<>(
            solution.subdomainVisits(new String[]{
                "900 google.mail.com",
                "50 yahoo.com",
                "1 intel.mail.com",
                "5 wiki.org"
            })
        )
    );
  }

}