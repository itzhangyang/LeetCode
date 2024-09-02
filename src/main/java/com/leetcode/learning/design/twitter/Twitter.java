package com.leetcode.learning.design.twitter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Twitter {
    // Map of userId to the list of userIds that the user is following
    private final Map<Integer, List<Integer>> following;
    // Map of userId to the list of tweetIds that the user has posted
    private final Map<Integer, List<Integer>> tweets;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<Integer> userTweets = tweets.getOrDefault(userId, new ArrayList<>());
        userTweets.add(tweetId);
        tweets.put(userId, userTweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>(); // List of tweetIds>
        List<Integer> followings = following.getOrDefault(userId, new ArrayList<>());
        if (!followings.isEmpty()) {
            for (int followingId : followings) {
                List<Integer> followingTweets = tweets.getOrDefault(followingId, new ArrayList<>());
                feed.addAll(followingTweets);
            }
        }
        return feed.stream().sorted(
                (t1, t2) -> t2 - t1
        ).limit(10)
                .collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> followings = following.getOrDefault(followerId, new ArrayList<>());
        followings.add(followeeId);
        following.put(followerId, followings);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followings = following.getOrDefault(followerId, new ArrayList<>());
        followings.remove(Integer.valueOf(followeeId));
        following.put(followerId, followings);
    }

}
