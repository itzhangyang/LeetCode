package com.leetcode.learning.design.keywordautocompleter;


import java.util.HashMap;
import java.util.Map;

public class Node {
    private boolean endOfWord;
    private final Map<Character, Node> children;

    public Node() {
        this.children = new HashMap<>();
    }

    public Map<Character, Node> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}
