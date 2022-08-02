package com.github.daddyingrave.leetcode.hashtables;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SubdomainVisitCount {
  public List<String> subdomainVisits(String[] cpdomains) {
    var domains = Arrays.stream(cpdomains).map(DomainsCounter::new).collect(Collectors.toList());
    var subDomainCounts = new HashMap<String, Integer>();

    for (DomainsCounter domain : domains) {
      var text = domain.domain;
      int index = 1;
      while (index > 0) {
        subDomainCounts.compute(text, (k, v) -> v == null ? domain.count : v + domain.count);
        var indexOf = text.indexOf('.');
        text = text.substring(indexOf + 1);
        index = indexOf;
      }
    }

    return subDomainCounts.entrySet()
        .stream()
        .map(e -> String.format("%d %s", e.getValue(), e.getKey()))
        .collect(Collectors.toList());
  }

  private static class DomainsCounter {
    public String domain;
    public int count;

    public DomainsCounter(String encodedCounter) {
      var countAndDomain = encodedCounter.split(" ");
      this.domain = countAndDomain[1];
      this.count = Integer.parseInt(countAndDomain[0]);
    }
  }
}
