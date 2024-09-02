package com.leetcode.learning.design.ratelimiter;

public class RateLimiter2 {
    private final int maxTokens; // maximum number of tokens in the bucket
    private final int refillTokens; // number of tokens to refill per second
    private final int refillInterval; // interval in milliseconds to refill tokens

    private int currentTokens; // current number of tokens in the bucket
    private long lastRefillTime; // last time the bucket was refilled

    public RateLimiter2(int maxTokens, int refillTokens, int refillInterval) {
        this.maxTokens = maxTokens;
        this.refillTokens = refillTokens;
        this.refillInterval = refillInterval;
        this.currentTokens = maxTokens;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public boolean tryAcquire() {
        refillBucket();
        if (currentTokens > 0) {
            currentTokens--;
            return true;
        }
        return false;
    }

    private void refillBucket() {
        long currentTime = System.currentTimeMillis();
        long elapsed = currentTime - lastRefillTime;
        int tokensToRefill = (int) (elapsed / refillInterval) * refillTokens;
        currentTokens = Math.min(maxTokens, currentTokens + tokensToRefill);
        lastRefillTime = currentTime;
    }
}
