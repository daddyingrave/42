package com.github.daddyingrave.ctci.arraysandstrings;

public class OneWay {
  public boolean isOneWay(String ref, String edited) {
    if (Math.abs(ref.length() - edited.length()) > 1) {
      return false;
    }
    
    String sh;
    String lng;
    if (ref.length() > edited.length()) {
      lng = ref;
      sh = edited;
    } else {
      lng = edited;
      sh = ref;
    }
    
    int i1 = 0;
    int i2 = 0;
    boolean unMatched = false;
    
    while (i1 < sh.length() && i2 < lng.length()) {
      if (sh.charAt(i1) != lng.charAt(i2)) {
        if (unMatched) {
          return false;
        } else {
          unMatched = true;
        }
        if (sh.length() == lng.length()) {
          i1++;
        }
      } else {
        i1++;
      }
      i2++;
    }
    
    return true;
  }
  // I'm not sure that it works
//  public boolean isOneWayMy(String ref, String edited) {
//    var table = new int[26];
//
//    for (int i = 0; i < ref.length(); i++) {
//      char ch = Character.toLowerCase(ref.charAt(i));
//      table[ch - 'a']++;
//    }
//
//    for (int i = 0; i < edited.length(); i++) {
//      char ch = Character.toLowerCase(edited.charAt(i));
//      table[ch - 'a']--;
//    }
//    
//    int sumPos = 0;
//    int sumNeg = 0;
//    for (int i : table) {
//      if (i < 0) {
//        sumNeg += i;
//      } else {
//        sumPos += i;
//      }
//    }
//    
//    if (sumNeg < -1) {
//      return false;
//    }
//    
//    return sumPos + sumNeg == 0 || sumPos + sumNeg == 1;
//  }
}
