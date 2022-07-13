package dataStructure.Trie;

import java.util.HashMap;

/**
 * Trie’s node can be implemented with array, linked list, HashMap. Each implementation has its pros and cons.
 * The character is used as key to find the pointer to the child node.
 * Hash map is preferred since its put and get operations take O(1) time.
 */
public class TrieHashMap {

    static class TrieNode {
        char data;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;

        TrieNode(char c) {
            data = c;
        }
    }

    static class Trie {
        TrieNode root = new TrieNode(' ');

        boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return false;
                }
                node = node.children.get(c);
            }
            return node.isEnd;
        }

        void insert(String word) {
            if (search(word)) {
                System.out.println(word + " is already in trie.");
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode(c));
                }
                node = node.children.get(c);
            }
            node.isEnd = true;
        }

        void delete(String word) {
            if (search(word)) {
                System.out.println(word + " does not exist in trie.");
                return;
            }

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    return;
                }
                node = node.children.get(c);
            }
            node.isEnd = false;
        }
    }
}
