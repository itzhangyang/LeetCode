package com.leetcode.notes.arrayandstring.canjump2;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * - 0 <= j <= nums[i]
 * - i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * 动态规划，使用一维数组
 */
public class Solution {
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        // dp[i] 表示能否到达索引 i
        boolean[] dp = new boolean[n];
        // 起始位置可以到达
        dp[0] = true;
        // 遍历数组，判断每个位置是否可以到达
        // i 表示当前位置，每一次内层循环都是判断当前位置是否可以到达
        for (int i = 1; i < n; i++) {
            // 遍历 i 之前的位置，判断每一个元素[0,i-1]是否可以到达 i
            // 如果存在一个元素可以到达 i, 则 i 可以到达
            for (int j = 0; j < i; j++) {
                // 如果 j 可以到达，且 j 可以到达 i, 则 i 可以到达
                // dp[j]=true 表示 j 可以到达
                // j + nums[j] >= i 表示 j 可以到达 i, 因为 j 可以到达的最远位置是 j + nums[j]
                if (dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    // 跳出循环，因为只要找到一个 j 可以到达 i, 就可以了
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *  * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *  * - 0 <= j <= nums[i]
     *  * - i + j < n
     *  * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * @param nums 数组
     * @return 最小跳跃次数
     */
    public int canJump3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp[i] 表示到达索引 i 的最小跳跃次数
        int[] jumpTimes = new int[n];
        // 初始化 dp 数组
        Arrays.fill(jumpTimes, Integer.MAX_VALUE);
        // 起始位置的最小跳跃次数是 0
        jumpTimes[0] = 0;
        // 遍历数组，计算每个位置的最小跳跃次数
        // i 表示当前位置，每一次内层循环都是计算当前位置的最小跳跃次数
        for (int i = 1; i < n; i++) {
            // 遍历 i 之前的位置，计算每一个元素[0,i-1]到达 i 的最小跳跃次数
            for (int j = 0; j < i; j++) {
                // 如果 j 可以到达 i, 则计算到达 i 的最小跳跃次数
                // j + nums[j] >= i 表示 j 可以到达 i, 因为 j 可以到达的最远位置是 j + nums[j]
                boolean canFromJJumpToI = j + nums[j] >= i;
                if (canFromJJumpToI) {
                    // 计算从0经过j到达i的跃次数
                    int jumps = jumpTimes[j] + 1;
                    // 更新到达 i 的最小跳跃次数
                    jumpTimes[i] = Math.min(jumpTimes[i], jumps);
                }
            }
        }
        return jumpTimes[n - 1];
    }
}
