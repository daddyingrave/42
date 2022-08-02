package com.github.daddyingrave.backtobackswe.stacksandqueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextEditorUndoRedoTest {

  TextEditorUndoRedo undoRedo = new TextEditorUndoRedo();

  @Test
  void performEditorActions() {
    assertEquals("a",
        undoRedo.performEditorActions(new String[][]{
            {"INSERT", "a"},
            {"INSERT", "b"},
            {"UNDO"}
        })
    );
    assertEquals("ab",
        undoRedo.performEditorActions(new String[][]{
            {"INSERT", "a"},
            {"INSERT", "b"},
            {"UNDO"},
            {"REDO"}
        })
    );
    assertEquals("ab",
        undoRedo.performEditorActions(new String[][]{
            {"INSERT", "a"},
            {"INSERT", "b"},
            {"UNDO"},
            {"REDO"},
            {"REDO"}
        })
    );
  }
}