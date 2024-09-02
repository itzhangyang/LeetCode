package com.leetcode.learning.design.keywordautocompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Trie {
    private final Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String keyword) {
        Node current = root;
        for (char c : keyword.toCharArray()) {
            Map<Character,Node> children= current.getChildren();
            // Put the character in the children map if it doesn't exist
            // Otherwise, get the existing node
            // Then, set the current node to the existing node
            current = children.computeIfAbsent(c, k -> new Node());
        }
        current.setEndOfWord(true);
    }

    public List<String> getSuggestions(String prefix) {
        Node current = root;
        for (char c : prefix.toCharArray()) {
            Map<Character, Node> children = current.getChildren();
            current = children.get(c);
            if (current == null) return Collections.emptyList();
        }
        return collectSuggestions(current, prefix);
    }

    private List<String> collectSuggestions(Node node, String prefix) {
        List<String> suggestions = new ArrayList<>();
        // If the node is the end of a word, add the prefix to the suggestions list
        if (node.isEndOfWord()) suggestions.add(prefix);
        Map<Character, Node> children = node.getChildren();
        children.forEach((character, child) ->
                suggestions.addAll(collectSuggestions(child, prefix + character)));
        return suggestions;
    }
}
