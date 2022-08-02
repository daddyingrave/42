package com.github.daddyingrave.backtobackswe.recursionbacktracking;

import java.util.ArrayList;
import java.util.List;

public class IPAddressRestoration {
  public List<String> restoreIpAddresses(String rawIpString) {
    var result = new ArrayList<String>();

    restoreIps(0, 0, new int[4], rawIpString, result);
    
    return result;
  }

  private void restoreIps(
      int progressIndex,
      int currentSegment,
      int[] ipAddressSegments,
      String rawIpString,
      List<String> restoredIps
  ) {
    if (currentSegment == 4 && progressIndex == rawIpString.length()) {
      restoredIps.add(toIp(ipAddressSegments));
    } else if (currentSegment == 4) {
      return;
    }

    for (int segLength = 1; segLength <= 3 && progressIndex + segLength <= rawIpString.length(); segLength++) {
      int currentPassSegmentLength = progressIndex + segLength;

      String segString = rawIpString.substring(progressIndex, currentPassSegmentLength);
      int ipPart = Integer.parseInt(segString);

      if (ipPart > 255 || segLength >= 2 && segString.charAt(0) == '0') {
        break;
      }

      ipAddressSegments[currentSegment] = ipPart;

      restoreIps(
          progressIndex + segLength,
          currentSegment + 1,
          ipAddressSegments,
          rawIpString,
          restoredIps
      );
    }
  }

  private String toIp(int[] segments) {
    return String.format("%d.%d.%d.%d", segments[0], segments[1], segments[2], segments[3]);
  }
}
