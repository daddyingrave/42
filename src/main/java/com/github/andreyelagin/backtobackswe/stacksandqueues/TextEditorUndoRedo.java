package com.github.andreyelagin.backtobackswe.stacksandqueues;

import java.util.Stack;

public class TextEditorUndoRedo {
  public String performEditorActions(String[][] actions) {
    var history = new Stack<String[]>();
    var undoHistory = new Stack<String[]>();
    var sb = new StringBuilder();
    var index = -1;

    for (String[] act : actions) {
      var action = act[0];
      var letter = act.length > 1 ? act[1] : null;
      if ("INSERT".equals(action)) {
        sb.append(letter);
        history.push(act);
        index++;
        undoHistory.clear();
      } else if ("DELETE".equals(action)) {
        sb.deleteCharAt(index--);
        history.push(new String[]{action, letter});
        undoHistory.clear();
      } else if ("UNDO".equals(action)) {
        if (!history.isEmpty()) {
          var cmd = history.pop();
          var undoAction = cmd[0];
          var undoLetter = cmd[1];
          if ("INSERT".equals(undoAction)) {
            sb.deleteCharAt(index--);
            undoHistory.push(cmd);
          } else if ("DELETE".equals(undoAction)) {
            sb.append(undoLetter);
            undoHistory.push(cmd);
            index++;
          }
        }
      } else if ("REDO".equals(action)) {
        if (!undoHistory.isEmpty()) {
          var cmd = undoHistory.pop();
          var redoAction = cmd[0];
          var redoLetter = cmd[1];
          if ("INSERT".equals(redoAction)) {
            sb.append(redoLetter);
            history.push(cmd);
            index++;
          } else if ("DELETE".equals(redoAction)) {
            sb.deleteCharAt(index--);
            history.push(cmd);
          }
        }
      }
    }

    return sb.toString();
  }
}
