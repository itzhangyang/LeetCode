package com.leetcode.learning.coupang;

import java.util.*;

public class KeywordAutoCompleter2 {
    private final Trie trie;

    public KeywordAutoCompleter2() {
        this.trie = new Trie();
    }

    public void addKeyword(String keyword) {
        trie.insert(keyword);
    }

    public List<String> suggest(String prefix) {
        return trie.getSuggestions(prefix);
    }

    private static class Node {
        private boolean endOfWord;
        private Map<Character, Node> children;

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

    private class Trie {
        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String keyword) {
            Node current = root;
            for (char c : keyword.toCharArray()) {
                Node node = current.getChildren().get(c);
                if (node == null) {
                    node = new Node();
                    current.getChildren().put(c, node);
                }
                current = node;
            }
            current.setEndOfWord(true);
        }

        public List<String> getSuggestions(String prefix) {
            Node current = root;
            for (char c : prefix.toCharArray()) {
                current = current.getChildren().get(c);
                if (current == null) return Collections.emptyList();
            }
            return collectSuggestions(current, prefix);
        }

        private List<String> collectSuggestions(Node node, String prefix) {
            List<String> suggestions = new ArrayList<>();
            if (node.isEndOfWord()) suggestions.add(prefix);
            for (Map.Entry<Character, Node> entry : node.getChildren().entrySet()) {
                suggestions.addAll(collectSuggestions(entry.getValue(), prefix + entry.getKey()));
            }
            return suggestions;
        }


    }
}
