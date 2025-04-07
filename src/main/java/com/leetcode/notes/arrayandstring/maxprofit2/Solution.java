package com.leetcode.notes.arrayandstring.maxprofit2;
/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。
 * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 分析过程
 * 1. 由于可以尽可能地完成更多的交易，因此只要今天的价格比昨天的价格高，就可以卖出股票，从而获取利润。
 * 2. 因此，只要今天的价格比昨天的价格高，就可以将这两天的价格差加入到最大利润中。
 */
public class Solution {
    public int maxProfit2(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfit = 0;
        int n = prices.length;

        for (int i = 1; i < n; i++) {
            int todayPrice = prices[i];
            int yesterdayPrice = prices[i - 1];

            if (todayPrice > yesterdayPrice) {
                int profit = todayPrice - yesterdayPrice;
                maxProfit += profit;
            }
        }

        return maxProfit;
    }
}
