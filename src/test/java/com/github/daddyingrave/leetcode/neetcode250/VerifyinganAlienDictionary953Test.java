package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class VerifyinganAlienDictionary953Test {
  class Solution {
    public boolean isAlienSorted(String[] words, String order) {
      var alphabet = new HashMap<Character, Integer>();
      for (int i = 0; i < order.length(); i++) {
        alphabet.put(order.charAt(i), i);
      }

      for (int i = 1; i < words.length; i++) {
        int commonLength = Math.min(words[i - 1].length(), words[i].length());
        int matched = 0;
        for (int j = 0; j < commonLength; j++) {
          Integer seqLeft = alphabet.get(words[i - 1].charAt(j));
          Integer seqRight = alphabet.get(words[i].charAt(j));
          if (seqLeft > seqRight) {
            return false;
          } else if (seqLeft < seqRight) {
            break;
          }

          matched++;
        }

        if (matched == commonLength && words[i - 1].length() > words[i].length()) {
          return false;
        }
      }

      return true;
    }
  }

  @Test
  void test() {
    assertTrue(new Solution().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    assertFalse(new Solution().isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
    assertFalse(new Solution().isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
  }
}
