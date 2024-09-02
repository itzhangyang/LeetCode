package com.leetcode.learning.design.circuitbreaker;

/**
 *
 */
public class CircuitBreaker {
    private int failureThreshold; // number of failures before opening the circuit
    private final int timeout; // time to wait before transitioning from open to half-open state
    private int maxRequestsInHalfOpenState; // max number of requests allowed in half-open state
    private State state; // current state of the circuit breaker
    private long lastFailureTime; // time of last failure

    /**
     * Constructor of the CircuitBreaker class
     * @param failureThreshold number of failures before opening the circuit
     * @param timeout time to wait before transitioning from open to half-open state
     * @param maxRequestsInHalfOpenState max number of requests allowed in half-open state
     */
    public CircuitBreaker(int failureThreshold, int timeout, int maxRequestsInHalfOpenState) {
        this.failureThreshold = failureThreshold;
        this.timeout = timeout;
        this.maxRequestsInHalfOpenState = maxRequestsInHalfOpenState;
        this.state = State.CLOSED;
    }

    // Attempt to execute a request
    public boolean execute(Runnable request) {
        if (state == State.OPEN) {
            // If the circuit is open, check if the timeout has expired
            if (System.currentTimeMillis() - lastFailureTime > timeout) {
                // Transition to half-open state
                state = State.HALF_OPEN;
            } else {
                // Circuit is still open, do not allow request to pass through
                return false;
            }
        }

        if (state == State.HALF_OPEN) {
            // If the circuit is half-open, check if the max number of requests has been reached
            if (maxRequestsInHalfOpenState > 0) {
                // Allow request to pass through
                maxRequestsInHalfOpenState--;
//                return true;
            } else {
                // Max number of requests reached, transition back to open state
                state = State.OPEN;
                return false;
            }
        }

        // If the circuit is closed, allow request to pass through
        try {
            request.run();
            return true;
        } catch (Exception e) {
            // If the request fails, increment the failure count
            lastFailureTime = System.currentTimeMillis();
            if (failureThreshold > 0) {
                failureThreshold--;
                if (failureThreshold == 0) {
                    // If the failure threshold is reached, transition to open state
                    state = State.OPEN;
                }
            }
            return false;
        }
    }

    private enum State {
        CLOSED,
        OPEN,
        HALF_OPEN
    }
}
