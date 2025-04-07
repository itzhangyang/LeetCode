package com.leetcode.notes.arrayandstring.randomizedset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 380. 常数时间插入、删除和获取随机元素
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * - insert(val)：当元素 val 不存在时，向集合中插入该项。
 * - remove(val)：元素 val 存在时，从集合中移除该项。
 * - getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 */
public class RandomizedSet {
    // 存储元素
    private final List<Integer> list;
    // 存储元素的索引
    private final Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * 向集合中插入元素 val
     * @param val 元素
     * @return 如果元素已存在，返回 false；否则返回 true
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        // 将元素添加到 list 的末尾
        list.add(val);
        // 将元素的索引添加到 map 中
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * 从集合中移除元素 val
     * @param val 元素
     * @return 如果元素不存在，返回 false；否则返回 true
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        // 获取元素的索引
        int index = map.get(val);
        // 将 list 的最后一个元素移动到 index 位置
        int last = list.get(list.size() - 1);
        list.set(index, last);
        map.put(last, index);
        // 删除最后一个元素
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * 随机返回现有集合中的一项
     * @return 随机元素
     */
    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
