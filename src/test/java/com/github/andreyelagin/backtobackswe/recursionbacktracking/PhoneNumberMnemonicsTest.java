package com.github.andreyelagin.backtobackswe.recursionbacktracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberMnemonicsTest {

  PhoneNumberMnemonics mnemonics = new PhoneNumberMnemonics();
  
  @Test
  void letterCombinations() {
    assertEquals(
        List.of("gd","ge","gf","hd","he","hf","id","ie","if"),
        mnemonics.letterCombinations("43")
    );
  }
}