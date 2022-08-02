package com.github.daddyingrave.backtobackswe.recursionbacktracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IPAddressRestorationTest {

  IPAddressRestoration restoration = new IPAddressRestoration();
  
  @Test
  void restoreIpAddresses() {
    assertEquals(
        List.of(
            "1.255.23.213",
            "1.255.232.13",
            "12.55.23.213",
            "12.55.232.13",
            "125.5.23.213",
            "125.5.232.13",
            "125.52.3.213",
            "125.52.32.13"
        ),
        restoration.restoreIpAddresses("125523213")
    );
  }
}