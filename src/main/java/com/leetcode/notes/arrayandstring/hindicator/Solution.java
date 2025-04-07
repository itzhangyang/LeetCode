package com.leetcode.notes.arrayandstring.hindicator;

/**
 * LeetCode 274. H 指数
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者发表的论文被引用的次数。
 * 计算并返回该研究者的 h 指数 。
 * h 指数的定义：
 * h 代表“高引用次数”（high citations），
 * 一名科研人员的 h 指数是指他（她）的 （n 篇论文中）
 * 总共有 h 篇论文分别被引用了至少 h 次。
 */
public class Solution {
    /**
     * 计数排序
     * @param citations 论文被引用次数,citations[i]表示第i篇论文的被引用次数
     * @return h 指数
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        // 计数排序,papers[i]表示被引用次数为i的论文数量
        // 为什么长度是n+1,引用次数不是没有限制吗？
        // 为了方便计算,引用次数大于n的论文都算在papers[n]里
        int[] papers = new int[n + 1];
        // 计数,统计被引用次数小于等于n的论文数量
        for (int c : citations) {
            if (c >= n) {
                papers[n]++;
            } else {
                papers[c]++;
            }
        }
        // 找出最大的h指数
        // k表示当前的h指数，c表示引用次数
        // h指数的取值范围是[0,n]
        // 从n开始递减，找到最大的h指数
        // 因为h <=n,所以papers[n]是n的最大值
        int hIndex = n;
        // c表示引用次数大于hIndex的论文数量
        int c = papers[hIndex];
        // 当hIndex > 引用次数大于hIndex的论文数量时
        // 说明hIndex不是h指数，因为hIndex篇论文被引用了至少hIndex次，
        // “至少”表明引用次数大于hIndex的论文数量要大于等于hIndex
        while (hIndex > c) {
            // hIndex递减
            hIndex--;
            // c表示引用次数,引用次数大于hIndex的论文数量
            c += papers[hIndex];
        }
        return hIndex;
    }
}
