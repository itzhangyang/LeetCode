package com.leetcode.learning.design.ratelimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiter3 {
    // RateLimiter class to limit the number of requests per second
    // Max number of requests per second
    private final int rate;
    private final int bucketSize;
    // Number of requests made in the last second
    private final AtomicInteger tokens = new AtomicInteger(0);

    public RateLimiter3(int rate) {
        this.rate = rate;
        this.bucketSize = rate * 10;
    }

    public boolean tryAcquire() {
        //
        int tokensToAdd = rate - tokens.get();
        if (tokensToAdd <= 0) {
            return true;
        }
        if (tokens.get() + tokensToAdd > bucketSize) {
            return false;
        }
        int newTokens = Math.min(tokens.get() + tokensToAdd, bucketSize);
        tokens.set(newTokens);
        return newTokens > 0;
    }
}
