package com.github.daddyingrave.leetcode.dsaforbeginners;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class DesignBrowserHistory1472Test {
  class BrowserHistory {
    final String home;
    final LinkedList<String> back = new LinkedList<>();
    final LinkedList<String> forward = new LinkedList<>();
    String current;

    public BrowserHistory(String homepage) {
      this.home = homepage;
      this.current = homepage;
    }

    public void visit(String url) {
      this.forward.clear();
      this.back.push(current);
      this.current = url;
    }

    public String back(int steps) {
      String page = "";
      while (steps > 0 && !this.back.isEmpty()) {
        page = this.back.pop();
        this.forward.push(this.current);
        this.current = page;
        steps--;
      }
      if (steps > 0) {
        this.current = home;
        return home;
      }

      return this.current;
    }

    public String forward(int steps) {
      String page = "";
      while (steps > 0 && !this.forward.isEmpty()) {
        page = this.forward.pop();
        this.back.push(this.current);
        this.current = page;
        steps--;
      }

      return this.current;
    }
  }

  @Test
  void test() {

    // hp: jrbilt.com
    // cccs.com
    // cmbw.com
    // iywwwfn.com
    // sktbhdx.com
    // bskj.com
    // thw.com <-
    BrowserHistory browserHistory = new BrowserHistory("jrbilt.com");
    browserHistory.visit("uiza.com");

    assertEquals("uiza.com", browserHistory.forward(3));
    assertEquals("uiza.com", browserHistory.forward(3));

    browserHistory.visit("fveyl.com");
    browserHistory.visit("hyhqfqf.com");

    assertEquals("jrbilt.com", browserHistory.back(3));

    browserHistory.visit("cccs.com");
    browserHistory.visit("bivz.com");

    assertEquals("bivz.com", browserHistory.forward(6));
    assertEquals("cccs.com", browserHistory.back(1));

    browserHistory.visit("cmbw.com");
    browserHistory.visit("iywwwfn.com");
    browserHistory.visit("sktbhdx.com");

    assertEquals("sktbhdx.com", browserHistory.forward(8));
    assertEquals("sktbhdx.com", browserHistory.forward(10));


    browserHistory.visit("bskj.com");
    browserHistory.visit("thw.com");

    assertEquals("jrbilt.com", browserHistory.back(6));
  }
}

// ["BrowserHistory"  [["jrbilt.com"]  [null          [null
// "visit"            ["uiza.com"]     null           null
// "forward"          [3]              "uiza.com"     "uiza.com"
// "forward"          [3]              "uiza.com"     "uiza.com"
// "visit"            ["fveyl.com"]    null           null
// "visit"            ["hyhqfqf.com"]  null           null
// "back"             [3]              "jrbilt.com"   "jrbilt.com"
// "visit"            ["cccs.com"]     null           null
// "visit"            ["bivz.com"]     null           null
// "forward"          [6]              "bivz.com"     "bivz.com"
// "back"             [1]              "cccs.com"     "cccs.com"
// "visit"            ["cmbw.com"]     null           null
// "visit"            ["iywwwfn.com"]  null           null
// "visit"            ["sktbhdx.com"]  null           null
// "forward"          [8]              "sktbhdx.com"  "sktbhdx.com"
// "forward"          [10]             "sktbhdx.com"  "sktbhdx.com"
// "visit"            ["bskj.com"]     null           null
// "visit"            ["thw.com"]      null           null
// "back"             [6]              "hyhqfqf.com"  "jrbilt.com"
// "visit"            ["hgesj.com"]    null           null
// "forward"          [6]              "hgesj.com"    "hgesj.com"
// "visit"            ["ctb.com"]      null           null
// "visit"            ["fllnc.com"]    null           null
// "visit"            ["fs.com"]       null           null
// "back"]            [7]]             "jrbilt.com"]  "jrbilt.com"]
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
