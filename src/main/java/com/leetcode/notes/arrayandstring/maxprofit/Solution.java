package com.leetcode.notes.arrayandstring.maxprofit;

/**
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 动态规划的做法
 * 分析过程
 */
public class Solution {
    public int maxProfit(int[] prices){
        if (prices == null || prices.length == 0){
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }
}
