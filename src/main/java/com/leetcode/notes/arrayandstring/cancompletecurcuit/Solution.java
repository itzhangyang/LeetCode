package com.leetcode.notes.arrayandstring.cancompletecurcuit;

/**
 * LeetCode 134. 加油站
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        // 如果总油量小于总消耗，无法环绕一圈
        if (totalGas < totalCost) {
            return -1;
        }

        int start = 0;
        int remain = 0;
        for (int i = 0; i < n; i++) {
            remain += gas[i] - cost[i];
            // 如果油量不够，从下一个加油站开始
            if (remain < 0) {
                start = i + 1;
                remain = 0;
            }
        }
        return start;
    }
}
