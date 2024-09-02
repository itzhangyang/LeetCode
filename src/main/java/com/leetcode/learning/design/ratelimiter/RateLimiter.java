package com.leetcode.learning.design.ratelimiter;

public class RateLimiter {
    // RateLimiter class to limit the number of requests per second
    private final int maxRequestPerSecond;
    // Number of requests made in the last second
    private int requestCount;
    // Time of the last request
    private long lastRequestTime;

    public RateLimiter(int maxRequestPerSecond) {
        this.maxRequestPerSecond = maxRequestPerSecond;
        this.requestCount = 0;
        this.lastRequestTime = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastRequestTime < 1000) {
            if (requestCount < maxRequestPerSecond) {
                requestCount++;
                return true;
            } else {
                return false;
            }
        } else {
            lastRequestTime = currentTime;
            requestCount = 1;
            return true;
        }
    }
}
