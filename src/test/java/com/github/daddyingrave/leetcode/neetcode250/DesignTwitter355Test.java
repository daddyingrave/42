package com.github.daddyingrave.leetcode.neetcode250;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter355Test {
  class Twitter {
    Map<Integer, List<Tweet>> tweets = new HashMap<>();
    Map<Integer, Set<Integer>> followers = new HashMap<>();
    int sequence = 0;

    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
      Tweet newTweet = new Tweet(tweetId, ++sequence);
      if (tweets.containsKey(userId)) {
        tweets.get(userId).add(newTweet);
      } else {
        var stack = new ArrayList<Tweet>();
        stack.add(newTweet);
        tweets.put(userId, stack);
      }
    }

    public List<Integer> getNewsFeed(int userId) {
      record feed(int index, int tweetSeq, List<Tweet> tweets) {
      }

      var subscriptions = new ArrayList<Integer>();
      subscriptions.add(userId);
      if (followers.containsKey(userId)) {
        subscriptions.addAll(followers.get(userId));
      }

      var heap = new PriorityQueue<feed>(Comparator.comparingInt(feed::tweetSeq).reversed());
      for (Integer subId : subscriptions) {
        if (tweets.containsKey(subId)) {
          List<Tweet> userTweets = tweets.get(subId);
          int last = userTweets.size() - 1;
          heap.offer(new feed(last, userTweets.get(last).seq, userTweets));
        }
      }

      var result = new ArrayList<Integer>();
      int count = 10;
      while (count > 0 && !heap.isEmpty()) {
        var latest = heap.poll();
        result.add(latest.tweets.get(latest.index).id);

        if (latest.index != 0) {
          heap.offer(new feed(latest.index - 1, latest.tweets.get(latest.index - 1).seq, latest.tweets));
        }

        count--;
      }

      return result;
    }

    public void follow(int followerId, int followeeId) {
      Set<Integer> following;
      if (followers.containsKey(followerId)) {
        following = followers.get(followerId);
      } else {
        following = new HashSet<>();
        followers.put(followerId, following);
      }

      following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
      if (followers.containsKey(followerId)) {
        followers.get(followerId).remove(followeeId);
      }
    }

    record Tweet(int id, int seq) implements Comparable<Tweet> {
      @Override
      public int compareTo(Tweet o) {
        return Integer.compare(this.seq, o.seq);
      }
    }
  }

  @Test
  void test() {
    Twitter twitter = new Twitter();
    twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
    twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
    twitter.follow(1, 2);    // User 1 follows user 2.
    twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
    twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
    twitter.unfollow(1, 2);  // User 1 unfollows user 2.
    twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
  }
}
